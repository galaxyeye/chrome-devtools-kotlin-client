@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Format (defaults to mhtml).
 */
@Serializable
public enum class CaptureSnapshotFormat {
  @SerialName("mhtml")
  MHTML,
}
