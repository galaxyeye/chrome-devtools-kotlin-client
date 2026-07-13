@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Determines what type of Trust Token operation is executed and
 * depending on the type, some additional parameters. The values
 * are specified in third_party/blink/renderer/core/fetch/trust_token.idl.
 */
@Serializable
@Experimental
data class TrustTokenParams(
  @property:SerialName("operation")
  val operation: TrustTokenOperationType,
  @property:SerialName("refreshPolicy")
  val refreshPolicy: TrustTokenParamsRefreshPolicy,
  @property:SerialName("issuers")
  @param:Optional
  val issuers: List<String>? = null,
)
