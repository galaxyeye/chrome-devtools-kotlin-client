@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

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
)
