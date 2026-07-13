@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RareIntegerData(
  @property:SerialName("index")
  val index: List<Int>,
  @property:SerialName("value")
  val `value`: List<Int>,
)
