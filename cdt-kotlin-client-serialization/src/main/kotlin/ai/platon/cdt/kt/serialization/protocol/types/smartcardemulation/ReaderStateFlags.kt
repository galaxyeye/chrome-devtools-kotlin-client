@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Maps to the |SCARD_STATE_*| flags.
 */
@Serializable
data class ReaderStateFlags(
  @property:SerialName("unaware")
  @param:Optional
  val unaware: Boolean? = null,
  @property:SerialName("ignore")
  @param:Optional
  val ignore: Boolean? = null,
  @property:SerialName("changed")
  @param:Optional
  val changed: Boolean? = null,
  @property:SerialName("unknown")
  @param:Optional
  val unknown: Boolean? = null,
  @property:SerialName("unavailable")
  @param:Optional
  val unavailable: Boolean? = null,
  @property:SerialName("empty")
  @param:Optional
  val empty: Boolean? = null,
  @property:SerialName("present")
  @param:Optional
  val present: Boolean? = null,
  @property:SerialName("exclusive")
  @param:Optional
  val exclusive: Boolean? = null,
  @property:SerialName("inuse")
  @param:Optional
  val inuse: Boolean? = null,
  @property:SerialName("mute")
  @param:Optional
  val mute: Boolean? = null,
  @property:SerialName("unpowered")
  @param:Optional
  val unpowered: Boolean? = null,
)
