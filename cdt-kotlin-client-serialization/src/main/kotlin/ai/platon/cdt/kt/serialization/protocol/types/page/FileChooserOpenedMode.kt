@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Input mode.
 */
@Serializable
public enum class FileChooserOpenedMode {
  @SerialName("selectSingle")
  SELECT_SINGLE,
  @SerialName("selectMultiple")
  SELECT_MULTIPLE,
}
