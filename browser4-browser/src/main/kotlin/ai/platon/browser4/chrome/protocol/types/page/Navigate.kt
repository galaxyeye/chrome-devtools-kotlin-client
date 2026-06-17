@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Navigate(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("loaderId")
  @param:Optional
  val loaderId: String? = null,
  @property:SerialName("errorText")
  @param:Optional
  val errorText: String? = null,
  @property:SerialName("isDownload")
  @param:Optional
  @param:Experimental
  val isDownload: Boolean? = null,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): Navigate = Navigate(frameId = "")
  }
}
