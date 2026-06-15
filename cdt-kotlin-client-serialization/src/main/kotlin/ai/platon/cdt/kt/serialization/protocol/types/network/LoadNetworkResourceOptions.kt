@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean

/**
 * An options object that may be extended later to better support CORS,
 * CORB and streaming.
 */
@Experimental
@Serializable
data class LoadNetworkResourceOptions(
  @SerialName("disableCache")
  val disableCache: Boolean,
  @SerialName("includeCredentials")
  val includeCredentials: Boolean,
)
