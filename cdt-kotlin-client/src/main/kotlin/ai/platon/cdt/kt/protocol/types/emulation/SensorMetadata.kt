@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double

@Experimental
data class SensorMetadata(
  @param:JsonProperty("available")
  @param:Optional
  val available: Boolean? = null,
  @param:JsonProperty("minimumFrequency")
  @param:Optional
  val minimumFrequency: Double? = null,
  @param:JsonProperty("maximumFrequency")
  @param:Optional
  val maximumFrequency: Double? = null,
)
