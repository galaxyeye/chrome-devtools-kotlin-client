@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

@Experimental
data class BlockPattern(
  @param:JsonProperty("urlPattern")
  val urlPattern: String,
  @param:JsonProperty("block")
  val block: Boolean,
)
