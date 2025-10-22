package ai.platon.cdt.kt.protocol.types.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Chrome histogram bucket.
 */
@Experimental
public data class Bucket(
  @field:JsonProperty("low")
  public val low: Int,
  @field:JsonProperty("high")
  public val high: Int,
  @field:JsonProperty("count")
  public val count: Int,
)
