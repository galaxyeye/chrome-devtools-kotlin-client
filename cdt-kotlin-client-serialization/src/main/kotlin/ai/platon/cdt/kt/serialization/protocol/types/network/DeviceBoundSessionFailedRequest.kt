@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details about a failed device bound session network request.
 */
@Serializable
@Experimental
data class DeviceBoundSessionFailedRequest(
  @property:SerialName("requestUrl")
  val requestUrl: String,
  @property:SerialName("netError")
  @param:Optional
  val netError: String? = null,
  @property:SerialName("responseError")
  @param:Optional
  val responseError: Int? = null,
  @property:SerialName("responseErrorBody")
  @param:Optional
  val responseErrorBody: String? = null,
)
