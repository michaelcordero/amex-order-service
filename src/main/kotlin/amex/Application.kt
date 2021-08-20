package amex

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import amex.plugins.*
import io.ktor.application.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

// Application wide (global) variables
val log: Logger = LoggerFactory.getLogger(Application::class.java)

fun main() {
    val server: NettyApplicationEngine  = embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }
    server.start(true)
}
