@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class SharedDictionaryError {
  @JsonProperty("UseErrorCrossOriginNoCorsRequest")
  USE_ERROR_CROSS_ORIGIN_NO_CORS_REQUEST,
  @JsonProperty("UseErrorDictionaryLoadFailure")
  USE_ERROR_DICTIONARY_LOAD_FAILURE,
  @JsonProperty("UseErrorMatchingDictionaryNotUsed")
  USE_ERROR_MATCHING_DICTIONARY_NOT_USED,
  @JsonProperty("UseErrorUnexpectedContentDictionaryHeader")
  USE_ERROR_UNEXPECTED_CONTENT_DICTIONARY_HEADER,
  @JsonProperty("WriteErrorCossOriginNoCorsRequest")
  WRITE_ERROR_COSS_ORIGIN_NO_CORS_REQUEST,
  @JsonProperty("WriteErrorDisallowedBySettings")
  WRITE_ERROR_DISALLOWED_BY_SETTINGS,
  @JsonProperty("WriteErrorExpiredResponse")
  WRITE_ERROR_EXPIRED_RESPONSE,
  @JsonProperty("WriteErrorFeatureDisabled")
  WRITE_ERROR_FEATURE_DISABLED,
  @JsonProperty("WriteErrorInsufficientResources")
  WRITE_ERROR_INSUFFICIENT_RESOURCES,
  @JsonProperty("WriteErrorInvalidMatchField")
  WRITE_ERROR_INVALID_MATCH_FIELD,
  @JsonProperty("WriteErrorInvalidStructuredHeader")
  WRITE_ERROR_INVALID_STRUCTURED_HEADER,
  @JsonProperty("WriteErrorInvalidTTLField")
  WRITE_ERROR_INVALID_TTL_FIELD,
  @JsonProperty("WriteErrorNavigationRequest")
  WRITE_ERROR_NAVIGATION_REQUEST,
  @JsonProperty("WriteErrorNoMatchField")
  WRITE_ERROR_NO_MATCH_FIELD,
  @JsonProperty("WriteErrorNonIntegerTTLField")
  WRITE_ERROR_NON_INTEGER_TTL_FIELD,
  @JsonProperty("WriteErrorNonListMatchDestField")
  WRITE_ERROR_NON_LIST_MATCH_DEST_FIELD,
  @JsonProperty("WriteErrorNonSecureContext")
  WRITE_ERROR_NON_SECURE_CONTEXT,
  @JsonProperty("WriteErrorNonStringIdField")
  WRITE_ERROR_NON_STRING_ID_FIELD,
  @JsonProperty("WriteErrorNonStringInMatchDestList")
  WRITE_ERROR_NON_STRING_IN_MATCH_DEST_LIST,
  @JsonProperty("WriteErrorInvalidMatchDestList")
  WRITE_ERROR_INVALID_MATCH_DEST_LIST,
  @JsonProperty("WriteErrorNonStringMatchField")
  WRITE_ERROR_NON_STRING_MATCH_FIELD,
  @JsonProperty("WriteErrorNonTokenTypeField")
  WRITE_ERROR_NON_TOKEN_TYPE_FIELD,
  @JsonProperty("WriteErrorRequestAborted")
  WRITE_ERROR_REQUEST_ABORTED,
  @JsonProperty("WriteErrorShuttingDown")
  WRITE_ERROR_SHUTTING_DOWN,
  @JsonProperty("WriteErrorTooLongIdField")
  WRITE_ERROR_TOO_LONG_ID_FIELD,
  @JsonProperty("WriteErrorUnsupportedType")
  WRITE_ERROR_UNSUPPORTED_TYPE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
