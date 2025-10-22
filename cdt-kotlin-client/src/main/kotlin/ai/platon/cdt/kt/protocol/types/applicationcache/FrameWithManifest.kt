package ai.platon.cdt.kt.protocol.types.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Frame identifier - manifest URL pair.
 */
data class FrameWithManifest(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("manifestURL")
  val manifestURL: String,
  @field:JsonProperty("status")
  val status: Int,
)
