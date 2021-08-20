package amex.plugins

import amex.routes.index
import amex.routes.order
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.routing.*


@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.configureRouting() {
    install(Locations) {
    }

    routing {
        index()
        order()
    }
}
