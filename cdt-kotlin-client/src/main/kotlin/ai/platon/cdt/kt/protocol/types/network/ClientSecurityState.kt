package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

@Experimental
public data class ClientSecurityState(
  @field:JsonProperty("initiatorIsSecureContext")
  public val initiatorIsSecureContext: Boolean,
  @field:JsonProperty("initiatorIPAddressSpace")
  public val initiatorIPAddressSpace: IPAddressSpace,
  @field:JsonProperty("privateNetworkRequestPolicy")
  public val privateNetworkRequestPolicy: PrivateNetworkRequestPolicy,
)
