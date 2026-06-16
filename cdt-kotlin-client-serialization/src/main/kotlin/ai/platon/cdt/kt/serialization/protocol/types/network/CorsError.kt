@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The reason why request was blocked.
 */
@Serializable
public enum class CorsError {
  @SerialName("DisallowedByMode")
  DISALLOWED_BY_MODE,
  @SerialName("InvalidResponse")
  INVALID_RESPONSE,
  @SerialName("WildcardOriginNotAllowed")
  WILDCARD_ORIGIN_NOT_ALLOWED,
  @SerialName("MissingAllowOriginHeader")
  MISSING_ALLOW_ORIGIN_HEADER,
  @SerialName("MultipleAllowOriginValues")
  MULTIPLE_ALLOW_ORIGIN_VALUES,
  @SerialName("InvalidAllowOriginValue")
  INVALID_ALLOW_ORIGIN_VALUE,
  @SerialName("AllowOriginMismatch")
  ALLOW_ORIGIN_MISMATCH,
  @SerialName("InvalidAllowCredentials")
  INVALID_ALLOW_CREDENTIALS,
  @SerialName("CorsDisabledScheme")
  CORS_DISABLED_SCHEME,
  @SerialName("PreflightInvalidStatus")
  PREFLIGHT_INVALID_STATUS,
  @SerialName("PreflightDisallowedRedirect")
  PREFLIGHT_DISALLOWED_REDIRECT,
  @SerialName("PreflightWildcardOriginNotAllowed")
  PREFLIGHT_WILDCARD_ORIGIN_NOT_ALLOWED,
  @SerialName("PreflightMissingAllowOriginHeader")
  PREFLIGHT_MISSING_ALLOW_ORIGIN_HEADER,
  @SerialName("PreflightMultipleAllowOriginValues")
  PREFLIGHT_MULTIPLE_ALLOW_ORIGIN_VALUES,
  @SerialName("PreflightInvalidAllowOriginValue")
  PREFLIGHT_INVALID_ALLOW_ORIGIN_VALUE,
  @SerialName("PreflightAllowOriginMismatch")
  PREFLIGHT_ALLOW_ORIGIN_MISMATCH,
  @SerialName("PreflightInvalidAllowCredentials")
  PREFLIGHT_INVALID_ALLOW_CREDENTIALS,
  @SerialName("PreflightMissingAllowExternal")
  PREFLIGHT_MISSING_ALLOW_EXTERNAL,
  @SerialName("PreflightInvalidAllowExternal")
  PREFLIGHT_INVALID_ALLOW_EXTERNAL,
  @SerialName("InvalidAllowMethodsPreflightResponse")
  INVALID_ALLOW_METHODS_PREFLIGHT_RESPONSE,
  @SerialName("InvalidAllowHeadersPreflightResponse")
  INVALID_ALLOW_HEADERS_PREFLIGHT_RESPONSE,
  @SerialName("MethodDisallowedByPreflightResponse")
  METHOD_DISALLOWED_BY_PREFLIGHT_RESPONSE,
  @SerialName("HeaderDisallowedByPreflightResponse")
  HEADER_DISALLOWED_BY_PREFLIGHT_RESPONSE,
  @SerialName("RedirectContainsCredentials")
  REDIRECT_CONTAINS_CREDENTIALS,
  @SerialName("InsecureLocalNetwork")
  INSECURE_LOCAL_NETWORK,
  @SerialName("InvalidLocalNetworkAccess")
  INVALID_LOCAL_NETWORK_ACCESS,
  @SerialName("NoCorsRedirectModeNotFollow")
  NO_CORS_REDIRECT_MODE_NOT_FOLLOW,
  @SerialName("LocalNetworkAccessPermissionDenied")
  LOCAL_NETWORK_ACCESS_PERMISSION_DENIED,
  UNKNOWN,
}
