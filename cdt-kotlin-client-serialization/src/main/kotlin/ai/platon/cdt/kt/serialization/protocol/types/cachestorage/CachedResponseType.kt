@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * type of HTTP response cached
 */
@Serializable
public enum class CachedResponseType {
  @SerialName("basic")
  BASIC,
  @SerialName("cors")
  CORS,
  @SerialName("default")
  DEFAULT,
  @SerialName("error")
  ERROR,
  @SerialName("opaqueResponse")
  OPAQUE_RESPONSE,
  @SerialName("opaqueRedirect")
  OPAQUE_REDIRECT,
}
