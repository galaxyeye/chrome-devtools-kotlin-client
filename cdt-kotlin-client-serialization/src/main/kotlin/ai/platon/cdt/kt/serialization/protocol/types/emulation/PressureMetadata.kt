@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class PressureMetadata(
  @property:SerialName("available")
  @param:Optional
  val available: Boolean? = null,
)
