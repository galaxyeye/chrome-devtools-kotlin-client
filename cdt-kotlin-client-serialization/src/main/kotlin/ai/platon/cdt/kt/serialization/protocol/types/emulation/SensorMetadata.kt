@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SensorMetadata(
  @property:SerialName("available")
  @param:Optional
  val available: Boolean? = null,
  @property:SerialName("minimumFrequency")
  @param:Optional
  val minimumFrequency: Double? = null,
  @property:SerialName("maximumFrequency")
  @param:Optional
  val maximumFrequency: Double? = null,
)
