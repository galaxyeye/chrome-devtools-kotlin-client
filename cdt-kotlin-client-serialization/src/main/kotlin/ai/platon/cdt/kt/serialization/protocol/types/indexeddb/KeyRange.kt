@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean

/**
 * Key range.
 */
@Serializable
data class KeyRange(
  @SerialName("lower")
  @param:Optional
  val lower: Key? = null,
  @SerialName("upper")
  @param:Optional
  val upper: Key? = null,
  @SerialName("lowerOpen")
  val lowerOpen: Boolean,
  @SerialName("upperOpen")
  val upperOpen: Boolean,
)
