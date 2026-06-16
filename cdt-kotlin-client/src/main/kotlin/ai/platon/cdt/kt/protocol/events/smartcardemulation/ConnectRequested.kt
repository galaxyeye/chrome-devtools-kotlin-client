@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.smartcardemulation

import ai.platon.cdt.kt.protocol.types.smartcardemulation.ProtocolSet
import ai.platon.cdt.kt.protocol.types.smartcardemulation.ShareMode
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when |SCardConnect| is called.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
 */
data class ConnectRequested(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("contextId")
  val contextId: Int,
  @param:JsonProperty("reader")
  val reader: String,
  @param:JsonProperty("shareMode")
  val shareMode: ShareMode,
  @param:JsonProperty("preferredProtocols")
  val preferredProtocols: ProtocolSet,
)
