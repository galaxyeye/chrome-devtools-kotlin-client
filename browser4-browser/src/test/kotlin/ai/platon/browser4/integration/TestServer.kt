package ai.platon.browser4.integration

import com.sun.net.httpserver.HttpServer
import java.io.File
import java.net.InetSocketAddress

/**
 * Embedded HTTP server using JDK HttpServer (zero extra dependencies).
 * Serves static HTML fixtures for integration tests.
 *
 * Usage:
 * ```
 * val server = TestServer.start()
 * val baseUrl = server.baseUrl
 * // ... run tests against baseUrl ...
 * server.stop()
 * ```
 */
class TestServer(private val server: HttpServer, val port: Int) {

    val baseUrl: String get() = "http://localhost:$port"

    fun stop() {
        server.stop(1)
    }

    companion object {
        private val fixturesDir = File("src/test/resources/integration")

        fun start(): TestServer {
            val server = HttpServer.create(InetSocketAddress(0), 0)
            val port = server.address.port

            server.createContext("/") { exchange ->
                val path = exchange.requestURI.path.removePrefix("/")
                val filename = when {
                    path.isEmpty() || path == "/" -> "simple.html"
                    path.endsWith(".html") -> path
                    else -> "$path.html"
                }
                val file = File(fixturesDir, filename)
                if (file.exists()) {
                    val bytes = file.readBytes()
                    exchange.responseHeaders.set("Content-Type", "text/html; charset=UTF-8")
                    exchange.sendResponseHeaders(200, bytes.size.toLong())
                    exchange.responseBody.use { it.write(bytes) }
                } else {
                    val body = "<html><body><h1>404 - $filename not found</h1></body></html>"
                    val bytes = body.toByteArray(Charsets.UTF_8)
                    exchange.sendResponseHeaders(404, bytes.size.toLong())
                    exchange.responseBody.use { it.write(bytes) }
                }
                exchange.close()
            }

            server.createContext("/headers") { exchange ->
                val headers = exchange.requestHeaders.entries
                    .joinToString("\n") { (key, values) -> "$key: ${values.joinToString(", ")}" }
                val body = "<html><body><pre>$headers</pre></body></html>"
                val bytes = body.toByteArray(Charsets.UTF_8)
                exchange.responseHeaders.set("Content-Type", "text/html; charset=UTF-8")
                exchange.sendResponseHeaders(200, bytes.size.toLong())
                exchange.responseBody.use { it.write(bytes) }
                exchange.close()
            }

            server.start()
            return TestServer(server, port)
        }
    }
}
