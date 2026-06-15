@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

@Serializable
data class DOMCounters(
  @SerialName("documents")
  val documents: Int,
  @SerialName("nodes")
  val nodes: Int,
  @SerialName("jsEventListeners")
  val jsEventListeners: Int,
)
