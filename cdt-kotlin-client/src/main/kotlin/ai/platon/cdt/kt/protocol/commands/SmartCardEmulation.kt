@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.smartcardemulation.BeginTransactionRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.CancelRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.ConnectRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.ControlRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.DisconnectRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.EndTransactionRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.EstablishContextRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.GetAttribRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.GetStatusChangeRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.ListReadersRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.ReleaseContextRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.SetAttribRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.StatusRequested
import ai.platon.cdt.kt.protocol.events.smartcardemulation.TransmitRequested
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.smartcardemulation.ConnectionState
import ai.platon.cdt.kt.protocol.types.smartcardemulation.Protocol
import ai.platon.cdt.kt.protocol.types.smartcardemulation.ReaderStateOut
import ai.platon.cdt.kt.protocol.types.smartcardemulation.ResultCode
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@Experimental
interface SmartCardEmulation {
  /**
   * Enables the |SmartCardEmulation| domain.
   */
  suspend fun enable()

  /**
   * Disables the |SmartCardEmulation| domain.
   */
  suspend fun disable()

  /**
   * Reports the successful result of a |SCardEstablishContext| call.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaa1b8970169fd4883a6dc4a8f43f19b67
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardestablishcontext
   * @param requestId
   * @param contextId
   */
  suspend fun reportEstablishContextResult(@ParamName("requestId") requestId: String, @ParamName("contextId") contextId: Int)

  /**
   * Reports the successful result of a |SCardReleaseContext| call.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga6aabcba7744c5c9419fdd6404f73a934
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardreleasecontext
   * @param requestId
   */
  suspend fun reportReleaseContextResult(@ParamName("requestId") requestId: String)

  /**
   * Reports the successful result of a |SCardListReaders| call.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga93b07815789b3cf2629d439ecf20f0d9
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardlistreadersa
   * @param requestId
   * @param readers
   */
  suspend fun reportListReadersResult(@ParamName("requestId") requestId: String, @ParamName("readers") readers: List<String>)

  /**
   * Reports the successful result of a |SCardGetStatusChange| call.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga33247d5d1257d59e55647c3bb717db24
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetstatuschangea
   * @param requestId
   * @param readerStates
   */
  suspend fun reportGetStatusChangeResult(@ParamName("requestId") requestId: String, @ParamName("readerStates") readerStates: List<ReaderStateOut>)

  /**
   * Reports the result of a |SCardBeginTransaction| call.
   * On success, this creates a new transaction object.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaddb835dce01a0da1d6ca02d33ee7d861
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardbegintransaction
   * @param requestId
   * @param handle
   */
  suspend fun reportBeginTransactionResult(@ParamName("requestId") requestId: String, @ParamName("handle") handle: Int)

  /**
   * Reports the successful result of a call that returns only a result code.
   * Used for: |SCardCancel|, |SCardDisconnect|, |SCardSetAttrib|, |SCardEndTransaction|.
   *
   * This maps to:
   * 1. SCardCancel
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaacbbc0c6d6c0cbbeb4f4debf6fbeeee6
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcancel
   *
   * 2. SCardDisconnect
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga4be198045c73ec0deb79e66c0ca1738a
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scarddisconnect
   *
   * 3. SCardSetAttrib
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga060f0038a4ddfd5dd2b8fadf3c3a2e4f
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardsetattrib
   *
   * 4. SCardEndTransaction
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gae8742473b404363e5c587f570d7e2f3b
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardendtransaction
   * @param requestId
   */
  suspend fun reportPlainResult(@ParamName("requestId") requestId: String)

  /**
   * Reports the successful result of a |SCardConnect| call.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
   * @param requestId
   * @param handle
   * @param activeProtocol
   */
  suspend fun reportConnectResult(
    @ParamName("requestId") requestId: String,
    @ParamName("handle") handle: Int,
    @ParamName("activeProtocol") @Optional activeProtocol: Protocol? = null,
  )

  suspend fun reportConnectResult(@ParamName("requestId") requestId: String, @ParamName("handle") handle: Int) {
    return reportConnectResult(requestId, handle, null)
  }

  /**
   * Reports the successful result of a call that sends back data on success.
   * Used for |SCardTransmit|, |SCardControl|, and |SCardGetAttrib|.
   *
   * This maps to:
   * 1. SCardTransmit
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#ga9a2d77242a271310269065e64633ab99
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardtransmit
   *
   * 2. SCardControl
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gac3454d4657110fd7f753b2d3d8f4e32f
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardcontrol
   *
   * 3. SCardGetAttrib
   *    PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gaacfec51917255b7a25b94c5104961602
   *    Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetattrib
   * @param requestId
   * @param data
   */
  suspend fun reportDataResult(@ParamName("requestId") requestId: String, @ParamName("data") `data`: String)

  /**
   * Reports the successful result of a |SCardStatus| call.
   *
   * This maps to:
   * PC/SC Lite: https://pcsclite.apdu.fr/api/group__API.html#gae49c3c894ad7ac12a5b896bde70d0382
   * Microsoft: https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardstatusa
   * @param requestId
   * @param readerName
   * @param state
   * @param atr
   * @param protocol
   */
  suspend fun reportStatusResult(
    @ParamName("requestId") requestId: String,
    @ParamName("readerName") readerName: String,
    @ParamName("state") state: ConnectionState,
    @ParamName("atr") atr: String,
    @ParamName("protocol") @Optional protocol: Protocol? = null,
  )

  suspend fun reportStatusResult(
    @ParamName("requestId") requestId: String,
    @ParamName("readerName") readerName: String,
    @ParamName("state") state: ConnectionState,
    @ParamName("atr") atr: String,
  ) {
    return reportStatusResult(requestId, readerName, state, atr, null)
  }

  /**
   * Reports an error result for the given request.
   * @param requestId
   * @param resultCode
   */
  suspend fun reportError(@ParamName("requestId") requestId: String, @ParamName("resultCode") resultCode: ResultCode)

  @EventName("establishContextRequested")
  fun onEstablishContextRequested(eventListener: EventHandler<EstablishContextRequested>): EventListener

  @EventName("establishContextRequested")
  fun onEstablishContextRequested(eventListener: suspend (EstablishContextRequested) -> Unit): EventListener

  @EventName("releaseContextRequested")
  fun onReleaseContextRequested(eventListener: EventHandler<ReleaseContextRequested>): EventListener

  @EventName("releaseContextRequested")
  fun onReleaseContextRequested(eventListener: suspend (ReleaseContextRequested) -> Unit): EventListener

  @EventName("listReadersRequested")
  fun onListReadersRequested(eventListener: EventHandler<ListReadersRequested>): EventListener

  @EventName("listReadersRequested")
  fun onListReadersRequested(eventListener: suspend (ListReadersRequested) -> Unit): EventListener

  @EventName("getStatusChangeRequested")
  fun onGetStatusChangeRequested(eventListener: EventHandler<GetStatusChangeRequested>): EventListener

  @EventName("getStatusChangeRequested")
  fun onGetStatusChangeRequested(eventListener: suspend (GetStatusChangeRequested) -> Unit): EventListener

  @EventName("cancelRequested")
  fun onCancelRequested(eventListener: EventHandler<CancelRequested>): EventListener

  @EventName("cancelRequested")
  fun onCancelRequested(eventListener: suspend (CancelRequested) -> Unit): EventListener

  @EventName("connectRequested")
  fun onConnectRequested(eventListener: EventHandler<ConnectRequested>): EventListener

  @EventName("connectRequested")
  fun onConnectRequested(eventListener: suspend (ConnectRequested) -> Unit): EventListener

  @EventName("disconnectRequested")
  fun onDisconnectRequested(eventListener: EventHandler<DisconnectRequested>): EventListener

  @EventName("disconnectRequested")
  fun onDisconnectRequested(eventListener: suspend (DisconnectRequested) -> Unit): EventListener

  @EventName("transmitRequested")
  fun onTransmitRequested(eventListener: EventHandler<TransmitRequested>): EventListener

  @EventName("transmitRequested")
  fun onTransmitRequested(eventListener: suspend (TransmitRequested) -> Unit): EventListener

  @EventName("controlRequested")
  fun onControlRequested(eventListener: EventHandler<ControlRequested>): EventListener

  @EventName("controlRequested")
  fun onControlRequested(eventListener: suspend (ControlRequested) -> Unit): EventListener

  @EventName("getAttribRequested")
  fun onGetAttribRequested(eventListener: EventHandler<GetAttribRequested>): EventListener

  @EventName("getAttribRequested")
  fun onGetAttribRequested(eventListener: suspend (GetAttribRequested) -> Unit): EventListener

  @EventName("setAttribRequested")
  fun onSetAttribRequested(eventListener: EventHandler<SetAttribRequested>): EventListener

  @EventName("setAttribRequested")
  fun onSetAttribRequested(eventListener: suspend (SetAttribRequested) -> Unit): EventListener

  @EventName("statusRequested")
  fun onStatusRequested(eventListener: EventHandler<StatusRequested>): EventListener

  @EventName("statusRequested")
  fun onStatusRequested(eventListener: suspend (StatusRequested) -> Unit): EventListener

  @EventName("beginTransactionRequested")
  fun onBeginTransactionRequested(eventListener: EventHandler<BeginTransactionRequested>): EventListener

  @EventName("beginTransactionRequested")
  fun onBeginTransactionRequested(eventListener: suspend (BeginTransactionRequested) -> Unit): EventListener

  @EventName("endTransactionRequested")
  fun onEndTransactionRequested(eventListener: EventHandler<EndTransactionRequested>): EventListener

  @EventName("endTransactionRequested")
  fun onEndTransactionRequested(eventListener: suspend (EndTransactionRequested) -> Unit): EventListener
}
