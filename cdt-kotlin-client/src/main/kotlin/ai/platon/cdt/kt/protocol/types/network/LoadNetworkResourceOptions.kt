package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * An options object that may be extended later to better support CORS,
 * CORB and streaming.
 */
@Experimental
data class LoadNetworkResourceOptions(
  @field:JsonProperty("disableCache")
  val disableCache: Boolean,
  @field:JsonProperty("includeCredentials")
  val includeCredentials: Boolean,
)
