@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TwaQualityEnforcementViolationType {
  @SerialName("kHttpError")
  K_HTTP_ERROR,
  @SerialName("kUnavailableOffline")
  K_UNAVAILABLE_OFFLINE,
  @SerialName("kDigitalAssetLinks")
  K_DIGITAL_ASSET_LINKS,
  UNKNOWN,
}
