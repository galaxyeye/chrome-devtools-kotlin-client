package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Generic font families collection.
 */
@Experimental
data class FontFamilies(
  @field:JsonProperty("standard")
  @param:Optional
  val standard: String? = null,
  @field:JsonProperty("fixed")
  @param:Optional
  val fixed: String? = null,
  @field:JsonProperty("serif")
  @param:Optional
  val serif: String? = null,
  @field:JsonProperty("sansSerif")
  @param:Optional
  val sansSerif: String? = null,
  @field:JsonProperty("cursive")
  @param:Optional
  val cursive: String? = null,
  @field:JsonProperty("fantasy")
  @param:Optional
  val fantasy: String? = null,
  @field:JsonProperty("pictograph")
  @param:Optional
  val pictograph: String? = null,
)
