package amex

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import amex.plugins.*

fun main() {
    val server: NettyApplicationEngine  = embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }
    server.start(true)
}
