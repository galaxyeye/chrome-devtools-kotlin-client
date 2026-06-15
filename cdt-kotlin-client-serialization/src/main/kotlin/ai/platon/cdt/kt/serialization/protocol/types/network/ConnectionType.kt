@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The underlying connection technology that the browser is supposedly using.
 */
@Serializable
public enum class ConnectionType {
  @SerialName("none")
  NONE,
  @SerialName("cellular2g")
  CELLULAR_2G,
  @SerialName("cellular3g")
  CELLULAR_3G,
  @SerialName("cellular4g")
  CELLULAR_4G,
  @SerialName("bluetooth")
  BLUETOOTH,
  @SerialName("ethernet")
  ETHERNET,
  @SerialName("wifi")
  WIFI,
  @SerialName("wimax")
  WIMAX,
  @SerialName("other")
  OTHER,
}
