@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AuthenticatorTransport {
  @SerialName("usb")
  USB,
  @SerialName("nfc")
  NFC,
  @SerialName("ble")
  BLE,
  @SerialName("cable")
  CABLE,
  @SerialName("internal")
  INTERNAL,
  UNKNOWN,
}
