@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.collections.List

/**
 * Data that is only present on rare nodes.
 */
@Serializable
data class RareStringData(
  @SerialName("index")
  val index: List<Int>,
  @SerialName("value")
  val `value`: List<Int>,
)
