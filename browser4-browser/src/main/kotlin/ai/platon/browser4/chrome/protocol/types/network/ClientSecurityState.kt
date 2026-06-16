@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ClientSecurityState(
  @property:SerialName("initiatorIsSecureContext")
  val initiatorIsSecureContext: Boolean,
  @property:SerialName("initiatorIPAddressSpace")
  val initiatorIPAddressSpace: IPAddressSpace,
  @property:SerialName("localNetworkAccessRequestPolicy")
  val localNetworkAccessRequestPolicy: LocalNetworkAccessRequestPolicy,
)
