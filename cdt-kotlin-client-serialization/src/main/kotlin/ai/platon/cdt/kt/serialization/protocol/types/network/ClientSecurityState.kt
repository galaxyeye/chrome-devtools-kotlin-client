@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean

@Experimental
@Serializable
data class ClientSecurityState(
  @SerialName("initiatorIsSecureContext")
  val initiatorIsSecureContext: Boolean,
  @SerialName("initiatorIPAddressSpace")
  val initiatorIPAddressSpace: IPAddressSpace,
  @SerialName("privateNetworkRequestPolicy")
  val privateNetworkRequestPolicy: PrivateNetworkRequestPolicy,
)
