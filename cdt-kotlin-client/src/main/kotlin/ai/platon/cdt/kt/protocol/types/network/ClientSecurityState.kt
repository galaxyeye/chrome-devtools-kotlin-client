package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

@Experimental
data class ClientSecurityState(
  @field:JsonProperty("initiatorIsSecureContext")
  val initiatorIsSecureContext: Boolean,
  @field:JsonProperty("initiatorIPAddressSpace")
  val initiatorIPAddressSpace: IPAddressSpace,
  @field:JsonProperty("privateNetworkRequestPolicy")
  val privateNetworkRequestPolicy: PrivateNetworkRequestPolicy,
)
