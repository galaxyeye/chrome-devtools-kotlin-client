@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * return as stream
 */
@Serializable
public enum class PrintToPDFTransferMode {
  @SerialName("ReturnAsBase64")
  RETURN_AS_BASE_64,
  @SerialName("ReturnAsStream")
  RETURN_AS_STREAM,
}
