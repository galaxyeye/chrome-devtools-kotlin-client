@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Generic font families collection.
 */
@Experimental
@Serializable
data class FontFamilies(
  @SerialName("standard")
  @param:Optional
  val standard: String? = null,
  @SerialName("fixed")
  @param:Optional
  val fixed: String? = null,
  @SerialName("serif")
  @param:Optional
  val serif: String? = null,
  @SerialName("sansSerif")
  @param:Optional
  val sansSerif: String? = null,
  @SerialName("cursive")
  @param:Optional
  val cursive: String? = null,
  @SerialName("fantasy")
  @param:Optional
  val fantasy: String? = null,
  @SerialName("pictograph")
  @param:Optional
  val pictograph: String? = null,
)
