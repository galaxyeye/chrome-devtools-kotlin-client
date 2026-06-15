@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Fired when page is about to start a download.
 */
@Experimental
@Serializable
data class DownloadWillBegin(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("guid")
  val guid: String,
  @SerialName("url")
  val url: String,
  @SerialName("suggestedFilename")
  val suggestedFilename: String,
)
