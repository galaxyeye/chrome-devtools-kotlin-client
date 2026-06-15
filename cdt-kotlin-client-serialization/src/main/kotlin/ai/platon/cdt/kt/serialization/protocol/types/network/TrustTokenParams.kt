@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Determines what type of Trust Token operation is executed and
 * depending on the type, some additional parameters. The values
 * are specified in third_party/blink/renderer/core/fetch/trust_token.idl.
 */
@Experimental
@Serializable
data class TrustTokenParams(
    // vincent, 2025/10/29,
    // com.fasterxml.jackson.databind.exc.ValueInstantiationException: Cannot construct instance of `ai.platon.cdt.kt.protocol.types.network.TrustTokenParams`, problem: Parameter specified as non-null is null: method ai.platon.cdt.kt.protocol.types.network.TrustTokenParams.<init>, parameter type
  @SerialName("type")
  @param:Optional
  val type: TrustTokenOperationType? = null,
  @SerialName("refreshPolicy")
  val refreshPolicy: TrustTokenParamsRefreshPolicy,
  @SerialName("issuers")
  @param:Optional
  val issuers: List<String>? = null,
)

