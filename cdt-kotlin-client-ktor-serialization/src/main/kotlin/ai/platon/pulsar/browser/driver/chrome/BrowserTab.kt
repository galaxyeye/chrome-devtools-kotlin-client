package ai.platon.pulsar.browser.driver.chrome

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.time.Instant

@Suppress("unused")
@Serializable
class BrowserTab {
    var id: String = ""
    var parentId: String? = null
    var description: String? = null
    var title: String? = null
    var type: String? = null
    var url: String? = null
    var devtoolsFrontendUrl: String? = null
    var webSocketDebuggerUrl: String? = null
    var faviconUrl: String? = null

    @Transient
    val createTime = Instant.now()

    val urlOrEmpty get() = url ?: ""

    fun isPageType(): Boolean = PAGE_TYPE == type

    companion object {
        const val PAGE_TYPE = "page"
    }
}
