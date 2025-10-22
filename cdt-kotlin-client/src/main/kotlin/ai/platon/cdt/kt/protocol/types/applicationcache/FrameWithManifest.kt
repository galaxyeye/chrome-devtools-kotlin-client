package ai.platon.cdt.kt.protocol.types.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Frame identifier - manifest URL pair.
 */
public data class FrameWithManifest(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("manifestURL")
  public val manifestURL: String,
  @field:JsonProperty("status")
  public val status: Int,
)
