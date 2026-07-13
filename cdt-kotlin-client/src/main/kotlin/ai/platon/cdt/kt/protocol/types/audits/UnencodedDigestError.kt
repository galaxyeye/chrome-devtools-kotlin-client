@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class UnencodedDigestError {
  @JsonProperty("MalformedDictionary")
  MALFORMED_DICTIONARY,
  @JsonProperty("UnknownAlgorithm")
  UNKNOWN_ALGORITHM,
  @JsonProperty("IncorrectDigestType")
  INCORRECT_DIGEST_TYPE,
  @JsonProperty("IncorrectDigestLength")
  INCORRECT_DIGEST_LENGTH,
  @JsonEnumDefaultValue
  UNKNOWN,
}
