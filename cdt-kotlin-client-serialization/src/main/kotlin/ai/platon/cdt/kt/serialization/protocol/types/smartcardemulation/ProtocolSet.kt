@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Maps to the |SCARD_PROTOCOL_*| flags.
 */
@Serializable
data class ProtocolSet(
  @property:SerialName("t0")
  @param:Optional
  val t0: Boolean? = null,
  @property:SerialName("t1")
  @param:Optional
  val t1: Boolean? = null,
  @property:SerialName("raw")
  @param:Optional
  val raw: Boolean? = null,
)
