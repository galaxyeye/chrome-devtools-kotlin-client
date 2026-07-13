@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.smartcardemulation

import ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation.ProtocolSet
import ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation.ShareMode
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when |SCardConnect| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
 */
@Serializable
data class ConnectRequested(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("contextId")
  val contextId: Int,
  @property:SerialName("reader")
  val reader: String,
  @property:SerialName("shareMode")
  val shareMode: ShareMode,
  @property:SerialName("preferredProtocols")
  val preferredProtocols: ProtocolSet,
)
