package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.page.ScreencastFrameMetadata
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Compressed image data requested by the `startScreencast`.
 */
@Experimental
public data class ScreencastFrame(
  @field:JsonProperty("data")
  public val `data`: String,
  @field:JsonProperty("metadata")
  public val metadata: ScreencastFrameMetadata,
  @field:JsonProperty("sessionId")
  public val sessionId: Int,
)
