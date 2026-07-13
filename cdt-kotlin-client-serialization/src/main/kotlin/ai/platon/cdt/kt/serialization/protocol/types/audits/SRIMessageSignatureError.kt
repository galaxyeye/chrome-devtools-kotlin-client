@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SRIMessageSignatureError {
  @SerialName("MissingSignatureHeader")
  MISSING_SIGNATURE_HEADER,
  @SerialName("MissingSignatureInputHeader")
  MISSING_SIGNATURE_INPUT_HEADER,
  @SerialName("InvalidSignatureHeader")
  INVALID_SIGNATURE_HEADER,
  @SerialName("InvalidSignatureInputHeader")
  INVALID_SIGNATURE_INPUT_HEADER,
  @SerialName("SignatureHeaderValueIsNotByteSequence")
  SIGNATURE_HEADER_VALUE_IS_NOT_BYTE_SEQUENCE,
  @SerialName("SignatureHeaderValueIsParameterized")
  SIGNATURE_HEADER_VALUE_IS_PARAMETERIZED,
  @SerialName("SignatureHeaderValueIsIncorrectLength")
  SIGNATURE_HEADER_VALUE_IS_INCORRECT_LENGTH,
  @SerialName("SignatureInputHeaderMissingLabel")
  SIGNATURE_INPUT_HEADER_MISSING_LABEL,
  @SerialName("SignatureInputHeaderValueNotInnerList")
  SIGNATURE_INPUT_HEADER_VALUE_NOT_INNER_LIST,
  @SerialName("SignatureInputHeaderValueMissingComponents")
  SIGNATURE_INPUT_HEADER_VALUE_MISSING_COMPONENTS,
  @SerialName("SignatureInputHeaderInvalidComponentType")
  SIGNATURE_INPUT_HEADER_INVALID_COMPONENT_TYPE,
  @SerialName("SignatureInputHeaderInvalidComponentName")
  SIGNATURE_INPUT_HEADER_INVALID_COMPONENT_NAME,
  @SerialName("SignatureInputHeaderInvalidHeaderComponentParameter")
  SIGNATURE_INPUT_HEADER_INVALID_HEADER_COMPONENT_PARAMETER,
  @SerialName("SignatureInputHeaderInvalidDerivedComponentParameter")
  SIGNATURE_INPUT_HEADER_INVALID_DERIVED_COMPONENT_PARAMETER,
  @SerialName("SignatureInputHeaderKeyIdLength")
  SIGNATURE_INPUT_HEADER_KEY_ID_LENGTH,
  @SerialName("SignatureInputHeaderInvalidParameter")
  SIGNATURE_INPUT_HEADER_INVALID_PARAMETER,
  @SerialName("SignatureInputHeaderMissingRequiredParameters")
  SIGNATURE_INPUT_HEADER_MISSING_REQUIRED_PARAMETERS,
  @SerialName("ValidationFailedSignatureExpired")
  VALIDATION_FAILED_SIGNATURE_EXPIRED,
  @SerialName("ValidationFailedInvalidLength")
  VALIDATION_FAILED_INVALID_LENGTH,
  @SerialName("ValidationFailedSignatureMismatch")
  VALIDATION_FAILED_SIGNATURE_MISMATCH,
  @SerialName("ValidationFailedIntegrityMismatch")
  VALIDATION_FAILED_INTEGRITY_MISMATCH,
  @SerialName("SignatureBaseUnknownDerivedComponent")
  SIGNATURE_BASE_UNKNOWN_DERIVED_COMPONENT,
  @SerialName("SignatureBaseMissingHeader")
  SIGNATURE_BASE_MISSING_HEADER,
  @SerialName("SignatureBaseInvalidUnencodedDigest")
  SIGNATURE_BASE_INVALID_UNENCODED_DIGEST,
  @SerialName("SignatureBaseUnsupportedComponent")
  SIGNATURE_BASE_UNSUPPORTED_COMPONENT,
  UNKNOWN,
}
