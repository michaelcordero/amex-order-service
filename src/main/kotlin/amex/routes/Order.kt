package amex.routes

import amex.db
import amex.log
import amex.model.Receipt
import amex.order_counter
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
@Location("/order")
class PostOrder {
    @Location("/{id}")
    data class Order(val id: String?, val postOrder: PostOrder)
    @Location("/all")
    class All(val postOrder: PostOrder)
}

@KtorExperimentalLocationsAPI
fun Route.order() {
    // Create
    post<PostOrder> {
        try {
            log.info("POST /order requested")
            val receipt: Receipt = call.receive()
            // save it to "database"
            order_counter += 1
            db[order_counter] = receipt
            call.respond(status = HttpStatusCode.OK, message = receipt.summary(0))
        } catch (e: Exception) {
            log.error(e.message)
            call.respond(status = HttpStatusCode.BadRequest, message = mapOf("error" to e.toString()))
        }
    }

    // Read
    get<PostOrder.Order> {
        try {
            log.info("GET /order/{id} requested")
            var receipt: Receipt? = Receipt(0,0)
            if (it.id != null) {
                receipt = db.get(it.id.toInt())
            }
            if (receipt != null) {
                call.respond(status = HttpStatusCode.OK, message = receipt.summary(it.id?.toInt()))
            }
        } catch (e: Exception) {
            log.error(e.message)
            call.respond(status = HttpStatusCode.BadRequest, message = mapOf("error" to e.toString()))
        }

    }

    get<PostOrder.All> {
        try {
            log.info("GET /order/all requested")
            call.respond(status = HttpStatusCode.OK, message = db.entries.map { entry -> entry.value.summary(entry.key) }.toString())
        } catch (e: Exception) {
            log.error(e.message)
            call.respond(status = HttpStatusCode.BadRequest, message = mapOf("error" to e.toString()))
        }
    }

}
