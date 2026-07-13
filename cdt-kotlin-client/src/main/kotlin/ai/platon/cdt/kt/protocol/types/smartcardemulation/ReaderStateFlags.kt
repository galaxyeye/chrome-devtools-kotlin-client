@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Maps to the |SCARD_STATE_*| flags.
 */
data class ReaderStateFlags(
  @param:JsonProperty("unaware")
  @param:Optional
  val unaware: Boolean? = null,
  @param:JsonProperty("ignore")
  @param:Optional
  val ignore: Boolean? = null,
  @param:JsonProperty("changed")
  @param:Optional
  val changed: Boolean? = null,
  @param:JsonProperty("unknown")
  @param:Optional
  val unknown: Boolean? = null,
  @param:JsonProperty("unavailable")
  @param:Optional
  val unavailable: Boolean? = null,
  @param:JsonProperty("empty")
  @param:Optional
  val empty: Boolean? = null,
  @param:JsonProperty("present")
  @param:Optional
  val present: Boolean? = null,
  @param:JsonProperty("exclusive")
  @param:Optional
  val exclusive: Boolean? = null,
  @param:JsonProperty("inuse")
  @param:Optional
  val inuse: Boolean? = null,
  @param:JsonProperty("mute")
  @param:Optional
  val mute: Boolean? = null,
  @param:JsonProperty("unpowered")
  @param:Optional
  val unpowered: Boolean? = null,
)
