@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key range.
 */
@Serializable
data class KeyRange(
  @property:SerialName("lower")
  @param:Optional
  val lower: Key? = null,
  @property:SerialName("upper")
  @param:Optional
  val upper: Key? = null,
  @property:SerialName("lowerOpen")
  val lowerOpen: Boolean,
  @property:SerialName("upperOpen")
  val upperOpen: Boolean,
)
