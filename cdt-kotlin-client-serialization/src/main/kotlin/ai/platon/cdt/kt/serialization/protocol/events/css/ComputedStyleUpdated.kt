@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ComputedStyleUpdated(
  @property:SerialName("nodeId")
  val nodeId: Int,
)
