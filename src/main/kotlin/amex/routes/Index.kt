package amex.routes

import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
@Location("/")
class Index

@KtorExperimentalLocationsAPI
fun Route.index() {
    get<Index> {
        call.respondText { "Hello Amex!" }
    }
}
