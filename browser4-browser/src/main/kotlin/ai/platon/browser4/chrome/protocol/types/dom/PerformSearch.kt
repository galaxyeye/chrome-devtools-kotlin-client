@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PerformSearch(
  @property:SerialName("searchId")
  val searchId: String,
  @property:SerialName("resultCount")
  val resultCount: Int,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): PerformSearch = PerformSearch(searchId = "", resultCount = 0)
  }
}
