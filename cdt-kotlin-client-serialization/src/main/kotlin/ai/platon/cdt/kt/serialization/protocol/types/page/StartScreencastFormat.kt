@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Image compression format.
 */
@Serializable
public enum class StartScreencastFormat {
  @SerialName("jpeg")
  JPEG,
  @SerialName("png")
  PNG,
}
