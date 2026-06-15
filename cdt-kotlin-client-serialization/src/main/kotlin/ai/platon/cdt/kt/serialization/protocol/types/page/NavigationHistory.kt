@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.collections.List

@Serializable
data class NavigationHistory(
  @SerialName("currentIndex")
  val currentIndex: Int,
  @SerialName("entries")
  val entries: List<NavigationEntry>,
)
