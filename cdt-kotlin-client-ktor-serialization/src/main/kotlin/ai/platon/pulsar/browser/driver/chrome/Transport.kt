package ai.platon.pulsar.browser.driver.chrome

import ai.platon.pulsar.browser.driver.chrome.util.ChromeIOException
import java.net.URI
import java.util.function.Consumer

interface Transport : AutoCloseable {
    val isOpen: Boolean

    @Throws(ChromeIOException::class)
    fun connect(uri: URI)

    @Throws(ChromeIOException::class)
    suspend fun send(message: String)

    fun addMessageHandler(consumer: Consumer<String>)
}
