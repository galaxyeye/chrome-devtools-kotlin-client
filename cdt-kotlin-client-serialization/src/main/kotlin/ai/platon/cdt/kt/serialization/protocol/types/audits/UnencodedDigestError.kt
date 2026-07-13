@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class UnencodedDigestError {
  @SerialName("MalformedDictionary")
  MALFORMED_DICTIONARY,
  @SerialName("UnknownAlgorithm")
  UNKNOWN_ALGORITHM,
  @SerialName("IncorrectDigestType")
  INCORRECT_DIGEST_TYPE,
  @SerialName("IncorrectDigestLength")
  INCORRECT_DIGEST_LENGTH,
  UNKNOWN,
}
