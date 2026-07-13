@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.browser

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.browser.DownloadProgressState
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when download makes progress. Last call has |done| == true.
 */
@Serializable
@Experimental
data class DownloadProgress(
  @property:SerialName("guid")
  val guid: String,
  @property:SerialName("totalBytes")
  val totalBytes: Double,
  @property:SerialName("receivedBytes")
  val receivedBytes: Double,
  @property:SerialName("state")
  val state: DownloadProgressState,
  @property:SerialName("filePath")
  @param:Optional
  @param:Experimental
  val filePath: String? = null,
)
