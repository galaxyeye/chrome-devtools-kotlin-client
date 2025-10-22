package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Generic font families collection.
 */
@Experimental
public data class FontFamilies(
  @field:JsonProperty("standard")
  @param:Optional
  public val standard: String? = null,
  @field:JsonProperty("fixed")
  @param:Optional
  public val fixed: String? = null,
  @field:JsonProperty("serif")
  @param:Optional
  public val serif: String? = null,
  @field:JsonProperty("sansSerif")
  @param:Optional
  public val sansSerif: String? = null,
  @field:JsonProperty("cursive")
  @param:Optional
  public val cursive: String? = null,
  @field:JsonProperty("fantasy")
  @param:Optional
  public val fantasy: String? = null,
  @field:JsonProperty("pictograph")
  @param:Optional
  public val pictograph: String? = null,
)
