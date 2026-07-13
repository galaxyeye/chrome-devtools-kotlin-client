@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ContentSecurityPolicySource {
  @SerialName("HTTP")
  HTTP,
  @SerialName("Meta")
  META,
  UNKNOWN,
}
