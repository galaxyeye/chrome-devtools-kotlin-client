@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

@Experimental
data class ComputedStyleUpdated(
  @param:JsonProperty("nodeId")
  val nodeId: Int,
)
