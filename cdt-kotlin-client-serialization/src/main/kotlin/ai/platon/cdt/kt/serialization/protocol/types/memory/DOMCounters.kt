@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DOMCounters(
  @property:SerialName("documents")
  val documents: Int,
  @property:SerialName("nodes")
  val nodes: Int,
  @property:SerialName("jsEventListeners")
  val jsEventListeners: Int,
)
