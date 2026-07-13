@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Generic font families collection.
 */
@Serializable
@Experimental
data class FontFamilies(
  @property:SerialName("standard")
  @param:Optional
  val standard: String? = null,
  @property:SerialName("fixed")
  @param:Optional
  val fixed: String? = null,
  @property:SerialName("serif")
  @param:Optional
  val serif: String? = null,
  @property:SerialName("sansSerif")
  @param:Optional
  val sansSerif: String? = null,
  @property:SerialName("cursive")
  @param:Optional
  val cursive: String? = null,
  @property:SerialName("fantasy")
  @param:Optional
  val fantasy: String? = null,
  @property:SerialName("math")
  @param:Optional
  val math: String? = null,
)
