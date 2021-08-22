package amex

import amex.model.Receipt
import amex.plugins.configureHTTP
import amex.plugins.configureMonitoring
import amex.plugins.configureRouting
import amex.plugins.configureSerialization
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.ConcurrentHashMap

// Application wide (global) variables
val log: Logger = LoggerFactory.getLogger(Application::class.java)
var order_counter: Int = 0
val db: MutableMap<Int,Receipt> = ConcurrentHashMap()

@KtorExperimentalLocationsAPI
fun main() {
    val server: NettyApplicationEngine  = embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }
    server.start(true)
}
