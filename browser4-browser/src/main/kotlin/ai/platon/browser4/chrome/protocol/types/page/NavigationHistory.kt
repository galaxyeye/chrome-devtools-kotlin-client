@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NavigationHistory(
  @property:SerialName("currentIndex")
  val currentIndex: Int,
  @property:SerialName("entries")
  val entries: List<NavigationEntry>,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): NavigationHistory = NavigationHistory(currentIndex = -1, entries = emptyList())
  }
}
