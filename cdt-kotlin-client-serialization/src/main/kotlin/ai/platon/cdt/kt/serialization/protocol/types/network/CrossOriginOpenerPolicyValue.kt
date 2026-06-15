@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class CrossOriginOpenerPolicyValue {
  @SerialName("SameOrigin")
  SAME_ORIGIN,
  @SerialName("SameOriginAllowPopups")
  SAME_ORIGIN_ALLOW_POPUPS,
  @SerialName("UnsafeNone")
  UNSAFE_NONE,
  @SerialName("SameOriginPlusCoep")
  SAME_ORIGIN_PLUS_COEP,
}
