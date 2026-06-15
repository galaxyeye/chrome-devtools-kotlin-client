@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.Map

/**
 * An object providing the result of a network resource load.
 */
@Experimental
@Serializable
data class LoadNetworkResourcePageResult(
  @SerialName("success")
  val success: Boolean,
  @SerialName("netError")
  @param:Optional
  val netError: Double? = null,
  @SerialName("netErrorName")
  @param:Optional
  val netErrorName: String? = null,
  @SerialName("httpStatusCode")
  @param:Optional
  val httpStatusCode: Double? = null,
  @SerialName("stream")
  @param:Optional
  val stream: String? = null,
  @SerialName("headers")
  @param:Optional
  val headers: Map<String, Any?>? = null,
)
