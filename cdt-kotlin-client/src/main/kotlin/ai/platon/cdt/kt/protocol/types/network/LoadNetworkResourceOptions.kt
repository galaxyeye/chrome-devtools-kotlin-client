package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * An options object that may be extended later to better support CORS,
 * CORB and streaming.
 */
@Experimental
public data class LoadNetworkResourceOptions(
  @field:JsonProperty("disableCache")
  public val disableCache: Boolean,
  @field:JsonProperty("includeCredentials")
  public val includeCredentials: Boolean,
)
