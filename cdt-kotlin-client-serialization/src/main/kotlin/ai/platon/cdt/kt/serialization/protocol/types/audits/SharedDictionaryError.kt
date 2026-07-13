@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SharedDictionaryError {
  @SerialName("UseErrorCrossOriginNoCorsRequest")
  USE_ERROR_CROSS_ORIGIN_NO_CORS_REQUEST,
  @SerialName("UseErrorDictionaryLoadFailure")
  USE_ERROR_DICTIONARY_LOAD_FAILURE,
  @SerialName("UseErrorMatchingDictionaryNotUsed")
  USE_ERROR_MATCHING_DICTIONARY_NOT_USED,
  @SerialName("UseErrorUnexpectedContentDictionaryHeader")
  USE_ERROR_UNEXPECTED_CONTENT_DICTIONARY_HEADER,
  @SerialName("WriteErrorCossOriginNoCorsRequest")
  WRITE_ERROR_COSS_ORIGIN_NO_CORS_REQUEST,
  @SerialName("WriteErrorDisallowedBySettings")
  WRITE_ERROR_DISALLOWED_BY_SETTINGS,
  @SerialName("WriteErrorExpiredResponse")
  WRITE_ERROR_EXPIRED_RESPONSE,
  @SerialName("WriteErrorFeatureDisabled")
  WRITE_ERROR_FEATURE_DISABLED,
  @SerialName("WriteErrorInsufficientResources")
  WRITE_ERROR_INSUFFICIENT_RESOURCES,
  @SerialName("WriteErrorInvalidMatchField")
  WRITE_ERROR_INVALID_MATCH_FIELD,
  @SerialName("WriteErrorInvalidStructuredHeader")
  WRITE_ERROR_INVALID_STRUCTURED_HEADER,
  @SerialName("WriteErrorInvalidTTLField")
  WRITE_ERROR_INVALID_TTL_FIELD,
  @SerialName("WriteErrorNavigationRequest")
  WRITE_ERROR_NAVIGATION_REQUEST,
  @SerialName("WriteErrorNoMatchField")
  WRITE_ERROR_NO_MATCH_FIELD,
  @SerialName("WriteErrorNonIntegerTTLField")
  WRITE_ERROR_NON_INTEGER_TTL_FIELD,
  @SerialName("WriteErrorNonListMatchDestField")
  WRITE_ERROR_NON_LIST_MATCH_DEST_FIELD,
  @SerialName("WriteErrorNonSecureContext")
  WRITE_ERROR_NON_SECURE_CONTEXT,
  @SerialName("WriteErrorNonStringIdField")
  WRITE_ERROR_NON_STRING_ID_FIELD,
  @SerialName("WriteErrorNonStringInMatchDestList")
  WRITE_ERROR_NON_STRING_IN_MATCH_DEST_LIST,
  @SerialName("WriteErrorInvalidMatchDestList")
  WRITE_ERROR_INVALID_MATCH_DEST_LIST,
  @SerialName("WriteErrorNonStringMatchField")
  WRITE_ERROR_NON_STRING_MATCH_FIELD,
  @SerialName("WriteErrorNonTokenTypeField")
  WRITE_ERROR_NON_TOKEN_TYPE_FIELD,
  @SerialName("WriteErrorRequestAborted")
  WRITE_ERROR_REQUEST_ABORTED,
  @SerialName("WriteErrorShuttingDown")
  WRITE_ERROR_SHUTTING_DOWN,
  @SerialName("WriteErrorTooLongIdField")
  WRITE_ERROR_TOO_LONG_ID_FIELD,
  @SerialName("WriteErrorUnsupportedType")
  WRITE_ERROR_UNSUPPORTED_TYPE,
  UNKNOWN,
}
