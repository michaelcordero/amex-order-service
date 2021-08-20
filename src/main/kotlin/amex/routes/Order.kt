package amex.routes

import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
@Location("/order")
class Order

@KtorExperimentalLocationsAPI
fun Route.order() {
    post<Order> {

    }
}
