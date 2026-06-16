@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class LocalNetworkAccessRequestPolicy {
  @SerialName("Allow")
  ALLOW,
  @SerialName("BlockFromInsecureToMorePrivate")
  BLOCK_FROM_INSECURE_TO_MORE_PRIVATE,
  @SerialName("WarnFromInsecureToMorePrivate")
  WARN_FROM_INSECURE_TO_MORE_PRIVATE,
  @SerialName("PermissionBlock")
  PERMISSION_BLOCK,
  @SerialName("PermissionWarn")
  PERMISSION_WARN,
  UNKNOWN,
}
