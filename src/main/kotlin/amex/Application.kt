package amex

import amex.model.Receipt
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import amex.plugins.*
import io.ktor.application.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

// Application wide (global) variables
val log: Logger = LoggerFactory.getLogger(Application::class.java)
var order_counter: Int = 0
val db: MutableMap<Int,Receipt> = ConcurrentHashMap()

fun main() {
    val server: NettyApplicationEngine  = embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }
    server.start(true)
}
