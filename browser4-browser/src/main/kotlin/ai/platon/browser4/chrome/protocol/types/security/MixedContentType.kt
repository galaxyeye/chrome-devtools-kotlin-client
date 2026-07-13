@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A description of mixed content (HTTP resources on HTTPS pages), as defined by
 * https://www.w3.org/TR/mixed-content/#categories
 */
@Serializable
public enum class MixedContentType {
  @SerialName("blockable")
  BLOCKABLE,
  @SerialName("optionally-blockable")
  OPTIONALLY_BLOCKABLE,
  @SerialName("none")
  NONE,
  UNKNOWN,
}
