@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Maps to the |SCARD_PROTOCOL_*| flags.
 */
data class ProtocolSet(
  @param:JsonProperty("t0")
  @param:Optional
  val t0: Boolean? = null,
  @param:JsonProperty("t1")
  @param:Optional
  val t1: Boolean? = null,
  @param:JsonProperty("raw")
  @param:Optional
  val raw: Boolean? = null,
)
