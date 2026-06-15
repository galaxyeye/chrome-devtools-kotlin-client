@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The encoding to use.
 */
@Serializable
public enum class GetEncodedResponseEncoding {
  @SerialName("webp")
  WEBP,
  @SerialName("jpeg")
  JPEG,
  @SerialName("png")
  PNG,
}
