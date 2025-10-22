package ai.platon.cdt.kt.protocol.types.headlessexperimental

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Encoding options for a screenshot.
 */
public data class ScreenshotParams(
  @field:JsonProperty("format")
  @param:Optional
  public val format: ScreenshotParamsFormat? = null,
  @field:JsonProperty("quality")
  @param:Optional
  public val quality: Int? = null,
)
