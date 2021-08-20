package amex.routes

import amex.log
import amex.model.Receipt
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
@Location("/order")
class Order

@KtorExperimentalLocationsAPI
fun Route.order() {
    post<Order> {
        try {
            log.info("POST /order requested")
            val receipt: Receipt = call.receive()
            call.respond(status = HttpStatusCode.OK, message = receipt.summary())
        } catch (e: Exception) {
            log.error(e.message)
            call.respond(status = HttpStatusCode.BadRequest, message = mapOf("error" to e.toString()))
        }
    }
}
