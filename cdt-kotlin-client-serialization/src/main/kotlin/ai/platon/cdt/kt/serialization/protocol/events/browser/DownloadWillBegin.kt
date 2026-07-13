@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.browser

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when page is about to start a download.
 */
@Serializable
@Experimental
data class DownloadWillBegin(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("guid")
  val guid: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("suggestedFilename")
  val suggestedFilename: String,
)
