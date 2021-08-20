package amex.api

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import amex.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello Amex!", response.content)
            }
        }
    }
}
