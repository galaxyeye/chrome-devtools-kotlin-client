@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PermissionElementIssueType {
  @SerialName("InvalidType")
  INVALID_TYPE,
  @SerialName("FencedFrameDisallowed")
  FENCED_FRAME_DISALLOWED,
  @SerialName("CspFrameAncestorsMissing")
  CSP_FRAME_ANCESTORS_MISSING,
  @SerialName("PermissionsPolicyBlocked")
  PERMISSIONS_POLICY_BLOCKED,
  @SerialName("PaddingRightUnsupported")
  PADDING_RIGHT_UNSUPPORTED,
  @SerialName("PaddingBottomUnsupported")
  PADDING_BOTTOM_UNSUPPORTED,
  @SerialName("InsetBoxShadowUnsupported")
  INSET_BOX_SHADOW_UNSUPPORTED,
  @SerialName("RequestInProgress")
  REQUEST_IN_PROGRESS,
  @SerialName("UntrustedEvent")
  UNTRUSTED_EVENT,
  @SerialName("RegistrationFailed")
  REGISTRATION_FAILED,
  @SerialName("TypeNotSupported")
  TYPE_NOT_SUPPORTED,
  @SerialName("InvalidTypeActivation")
  INVALID_TYPE_ACTIVATION,
  @SerialName("SecurityChecksFailed")
  SECURITY_CHECKS_FAILED,
  @SerialName("ActivationDisabled")
  ACTIVATION_DISABLED,
  @SerialName("GeolocationDeprecated")
  GEOLOCATION_DEPRECATED,
  @SerialName("InvalidDisplayStyle")
  INVALID_DISPLAY_STYLE,
  @SerialName("NonOpaqueColor")
  NON_OPAQUE_COLOR,
  @SerialName("LowContrast")
  LOW_CONTRAST,
  @SerialName("FontSizeTooSmall")
  FONT_SIZE_TOO_SMALL,
  @SerialName("FontSizeTooLarge")
  FONT_SIZE_TOO_LARGE,
  @SerialName("InvalidSizeValue")
  INVALID_SIZE_VALUE,
  UNKNOWN,
}
