@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PermissionElementIssueType {
  @JsonProperty("InvalidType")
  INVALID_TYPE,
  @JsonProperty("FencedFrameDisallowed")
  FENCED_FRAME_DISALLOWED,
  @JsonProperty("CspFrameAncestorsMissing")
  CSP_FRAME_ANCESTORS_MISSING,
  @JsonProperty("PermissionsPolicyBlocked")
  PERMISSIONS_POLICY_BLOCKED,
  @JsonProperty("PaddingRightUnsupported")
  PADDING_RIGHT_UNSUPPORTED,
  @JsonProperty("PaddingBottomUnsupported")
  PADDING_BOTTOM_UNSUPPORTED,
  @JsonProperty("InsetBoxShadowUnsupported")
  INSET_BOX_SHADOW_UNSUPPORTED,
  @JsonProperty("RequestInProgress")
  REQUEST_IN_PROGRESS,
  @JsonProperty("UntrustedEvent")
  UNTRUSTED_EVENT,
  @JsonProperty("RegistrationFailed")
  REGISTRATION_FAILED,
  @JsonProperty("TypeNotSupported")
  TYPE_NOT_SUPPORTED,
  @JsonProperty("InvalidTypeActivation")
  INVALID_TYPE_ACTIVATION,
  @JsonProperty("SecurityChecksFailed")
  SECURITY_CHECKS_FAILED,
  @JsonProperty("ActivationDisabled")
  ACTIVATION_DISABLED,
  @JsonProperty("GeolocationDeprecated")
  GEOLOCATION_DEPRECATED,
  @JsonProperty("InvalidDisplayStyle")
  INVALID_DISPLAY_STYLE,
  @JsonProperty("NonOpaqueColor")
  NON_OPAQUE_COLOR,
  @JsonProperty("LowContrast")
  LOW_CONTRAST,
  @JsonProperty("FontSizeTooSmall")
  FONT_SIZE_TOO_SMALL,
  @JsonProperty("FontSizeTooLarge")
  FONT_SIZE_TOO_LARGE,
  @JsonProperty("InvalidSizeValue")
  INVALID_SIZE_VALUE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
