@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.domsnapshot

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RareBooleanData(
  @property:SerialName("index")
  val index: List<Int>,
)
