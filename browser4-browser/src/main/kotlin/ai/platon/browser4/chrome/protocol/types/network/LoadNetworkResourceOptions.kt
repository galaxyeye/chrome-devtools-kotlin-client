@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An options object that may be extended later to better support CORS,
 * CORB and streaming.
 */
@Serializable
@Experimental
data class LoadNetworkResourceOptions(
  @property:SerialName("disableCache")
  val disableCache: Boolean,
  @property:SerialName("includeCredentials")
  val includeCredentials: Boolean,
)
