@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TrustTokenOperationType {
  @SerialName("Issuance")
  ISSUANCE,
  @SerialName("Redemption")
  REDEMPTION,
  @SerialName("Signing")
  SIGNING,
  UNKNOWN,
}
