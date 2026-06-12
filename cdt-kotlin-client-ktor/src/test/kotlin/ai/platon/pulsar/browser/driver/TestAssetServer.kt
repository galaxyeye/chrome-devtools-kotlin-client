/*-
 * #%L
 * cdt-kotlin-client
 * %%
 * Copyright (C) 2025 platon.ai
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package ai.platon.pulsar.browser.driver

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.URLConnection
import java.nio.charset.StandardCharsets

internal class TestAssetServer private constructor(private val server: HttpServer) : AutoCloseable {
    companion object {
        private const val ASSET_ROOT = "static/assets"

        fun start(): TestAssetServer {
            val server = HttpServer.create(InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0)
            val assetServer = TestAssetServer(server)
            server.createContext("/") { exchange -> assetServer.handle(exchange) }
            server.start()
            return assetServer
        }
    }

    private val classLoader = javaClass.classLoader

    fun url(path: String): String {
        val normalizedPath = if (path.startsWith("/")) path else "/$path"
        return "http://127.0.0.1:${server.address.port}$normalizedPath"
    }

    override fun close() {
        server.stop(0)
    }

    private fun handle(exchange: HttpExchange) {
        exchange.use {
            if (exchange.requestMethod != "GET") {
                send(exchange, 405, "Method Not Allowed".toByteArray(StandardCharsets.UTF_8), "text/plain; charset=utf-8")
                return
            }

            val resourcePath = toResourcePath(exchange.requestURI.path)
            val body = classLoader.getResourceAsStream(resourcePath)?.use { it.readBytes() }
            if (body == null) {
                send(exchange, 404, "Not Found".toByteArray(StandardCharsets.UTF_8), "text/plain; charset=utf-8")
                return
            }

            val contentType = URLConnection.guessContentTypeFromName(resourcePath) ?: "application/octet-stream"
            send(exchange, 200, body, contentType)
        }
    }

    private fun toResourcePath(requestPath: String): String {
        val trimmed = requestPath.trim().removePrefix("/")
        require(".." !in trimmed.split('/')) { "Parent directory traversal is not allowed: $requestPath" }
        return "$ASSET_ROOT/$trimmed"
    }

    private fun send(exchange: HttpExchange, statusCode: Int, body: ByteArray, contentType: String) {
        exchange.responseHeaders.add("Content-Type", contentType)
        exchange.sendResponseHeaders(statusCode, body.size.toLong())
        exchange.responseBody.use { output -> output.write(body) }
    }
}
