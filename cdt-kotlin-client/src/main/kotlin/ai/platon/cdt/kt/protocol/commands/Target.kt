package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.target.AttachedToTarget
import ai.platon.cdt.kt.protocol.events.target.DetachedFromTarget
import ai.platon.cdt.kt.protocol.events.target.ReceivedMessageFromTarget
import ai.platon.cdt.kt.protocol.events.target.TargetCrashed
import ai.platon.cdt.kt.protocol.events.target.TargetCreated
import ai.platon.cdt.kt.protocol.events.target.TargetDestroyed
import ai.platon.cdt.kt.protocol.events.target.TargetInfoChanged
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.target.RemoteLocation
import ai.platon.cdt.kt.protocol.types.target.TargetInfo
import java.lang.Deprecated
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Supports additional targets discovery and allows to attach to them.
 */
public interface Target {
  /**
   * Activates (focuses) the target.
   * @param targetId
   */
  public suspend fun activateTarget(@ParamName("targetId") targetId: String)

  /**
   * Attaches to the target with given id.
   * @param targetId
   * @param flatten Enables "flat" access to the session via specifying sessionId attribute in the
   * commands.
   * We plan to make this the default, deprecate non-flattened mode,
   * and eventually retire it. See crbug.com/991325.
   */
  @Returns("sessionId")
  public suspend fun attachToTarget(@ParamName("targetId") targetId: String, @ParamName("flatten")
      @Optional flatten: Boolean?): String

  @Returns("sessionId")
  public suspend fun attachToTarget(@ParamName("targetId") targetId: String): String {
    return attachToTarget(targetId, null)
  }

  /**
   * Attaches to the browser target, only uses flat sessionId mode.
   */
  @Experimental
  @Returns("sessionId")
  public suspend fun attachToBrowserTarget(): String

  /**
   * Closes the target. If the target is a page that gets closed too.
   * @param targetId
   */
  @Returns("success")
  public suspend fun closeTarget(@ParamName("targetId") targetId: String): Boolean

  /**
   * Inject object to the target's main frame that provides a communication
   * channel with browser target.
   *
   * Injected object will be available as `window[bindingName]`.
   *
   * The object has the follwing API:
   * - `binding.send(json)` - a method to send messages over the remote debugging protocol
   * - `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the
   * protocol notifications and command responses.
   * @param targetId
   * @param bindingName Binding name, 'cdp' if not specified.
   */
  @Experimental
  public suspend fun exposeDevToolsProtocol(@ParamName("targetId") targetId: String,
      @ParamName("bindingName") @Optional bindingName: String?)

  @Experimental
  public suspend fun exposeDevToolsProtocol(@ParamName("targetId") targetId: String) {
    return exposeDevToolsProtocol(targetId, null)
  }

  /**
   * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
   * one.
   * @param disposeOnDetach If specified, disposes this context when debugging session disconnects.
   * @param proxyServer Proxy server, similar to the one passed to --proxy-server
   * @param proxyBypassList Proxy bypass list, similar to the one passed to --proxy-bypass-list
   */
  @Experimental
  @Returns("browserContextId")
  public suspend fun createBrowserContext(
    @ParamName("disposeOnDetach") @Optional disposeOnDetach: Boolean?,
    @ParamName("proxyServer") @Optional proxyServer: String?,
    @ParamName("proxyBypassList") @Optional proxyBypassList: String?,
  ): String

  @Experimental
  @Returns("browserContextId")
  public suspend fun createBrowserContext(): String {
    return createBrowserContext(null, null, null)
  }

  /**
   * Returns all browser contexts created with `Target.createBrowserContext` method.
   */
  @Experimental
  @Returns("browserContextIds")
  @ReturnTypeParameter(String::class)
  public suspend fun getBrowserContexts(): List<String>

  /**
   * Creates a new page.
   * @param url The initial URL the page will be navigated to. An empty string indicates
   * about:blank.
   * @param width Frame width in DIP (headless chrome only).
   * @param height Frame height in DIP (headless chrome only).
   * @param browserContextId The browser context to create the page in.
   * @param enableBeginFrameControl Whether BeginFrames for this target will be controlled via
   * DevTools (headless chrome only,
   * not supported on MacOS yet, false by default).
   * @param newWindow Whether to create a new Window or Tab (chrome-only, false by default).
   * @param background Whether to create the target in background or foreground (chrome-only,
   * false by default).
   */
  @Returns("targetId")
  public suspend fun createTarget(
    @ParamName("url") url: String,
    @ParamName("width") @Optional width: Int?,
    @ParamName("height") @Optional height: Int?,
    @ParamName("browserContextId") @Optional browserContextId: String?,
    @ParamName("enableBeginFrameControl") @Optional @Experimental enableBeginFrameControl: Boolean?,
    @ParamName("newWindow") @Optional newWindow: Boolean?,
    @ParamName("background") @Optional background: Boolean?,
  ): String

  @Returns("targetId")
  public suspend fun createTarget(@ParamName("url") url: String): String {
    return createTarget(url, null, null, null, null, null, null)
  }

  /**
   * Detaches session with given id.
   * @param sessionId Session to detach.
   * @param targetId Deprecated.
   */
  public suspend fun detachFromTarget(@ParamName("sessionId") @Optional sessionId: String?,
      @ParamName("targetId") @Optional @Deprecated targetId: String?)

  public suspend fun detachFromTarget() {
    return detachFromTarget(null, null)
  }

  /**
   * Deletes a BrowserContext. All the belonging pages will be closed without calling their
   * beforeunload hooks.
   * @param browserContextId
   */
  @Experimental
  public suspend fun disposeBrowserContext(@ParamName("browserContextId") browserContextId: String)

  /**
   * Returns information about a target.
   * @param targetId
   */
  @Experimental
  @Returns("targetInfo")
  public suspend fun getTargetInfo(@ParamName("targetId") @Optional targetId: String?): TargetInfo

  @Experimental
  @Returns("targetInfo")
  public suspend fun getTargetInfo(): TargetInfo {
    return getTargetInfo(null)
  }

  /**
   * Retrieves a list of available targets.
   */
  @Returns("targetInfos")
  @ReturnTypeParameter(TargetInfo::class)
  public suspend fun getTargets(): List<TargetInfo>

  /**
   * Sends protocol message over session with given id.
   * Consider using flat mode instead; see commands attachToTarget, setAutoAttach,
   * and crbug.com/991325.
   * @param message
   * @param sessionId Identifier of the session.
   * @param targetId Deprecated.
   */
  @Deprecated
  public suspend fun sendMessageToTarget(
    @ParamName("message") message: String,
    @ParamName("sessionId") @Optional sessionId: String?,
    @ParamName("targetId") @Optional @Deprecated targetId: String?,
  )

  @Deprecated
  public suspend fun sendMessageToTarget(@ParamName("message") message: String) {
    return sendMessageToTarget(message, null, null)
  }

  /**
   * Controls whether to automatically attach to new targets which are considered to be related to
   * this one. When turned on, attaches to all existing related targets as well. When turned off,
   * automatically detaches from all currently attached targets.
   * @param autoAttach Whether to auto-attach to related targets.
   * @param waitForDebuggerOnStart Whether to pause new targets when attaching to them. Use
   * `Runtime.runIfWaitingForDebugger`
   * to run paused targets.
   * @param flatten Enables "flat" access to the session via specifying sessionId attribute in the
   * commands.
   * We plan to make this the default, deprecate non-flattened mode,
   * and eventually retire it. See crbug.com/991325.
   */
  @Experimental
  public suspend fun setAutoAttach(
    @ParamName("autoAttach") autoAttach: Boolean,
    @ParamName("waitForDebuggerOnStart") waitForDebuggerOnStart: Boolean,
    @ParamName("flatten") @Optional flatten: Boolean?,
  )

  @Experimental
  public suspend fun setAutoAttach(@ParamName("autoAttach") autoAttach: Boolean,
      @ParamName("waitForDebuggerOnStart") waitForDebuggerOnStart: Boolean) {
    return setAutoAttach(autoAttach, waitForDebuggerOnStart, null)
  }

  /**
   * Controls whether to discover available targets and notify via
   * `targetCreated/targetInfoChanged/targetDestroyed` events.
   * @param discover Whether to discover available targets.
   */
  public suspend fun setDiscoverTargets(@ParamName("discover") discover: Boolean)

  /**
   * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
   * `true`.
   * @param locations List of remote locations.
   */
  @Experimental
  public suspend fun setRemoteLocations(@ParamName("locations") locations: List<RemoteLocation>)

  @EventName("attachedToTarget")
  @Experimental
  public fun onAttachedToTarget(eventListener: EventHandler<AttachedToTarget>): EventListener

  @EventName("detachedFromTarget")
  @Experimental
  public fun onDetachedFromTarget(eventListener: EventHandler<DetachedFromTarget>): EventListener

  @EventName("receivedMessageFromTarget")
  public fun onReceivedMessageFromTarget(eventListener: EventHandler<ReceivedMessageFromTarget>):
      EventListener

  @EventName("targetCreated")
  public fun onTargetCreated(eventListener: EventHandler<TargetCreated>): EventListener

  @EventName("targetDestroyed")
  public fun onTargetDestroyed(eventListener: EventHandler<TargetDestroyed>): EventListener

  @EventName("targetCrashed")
  public fun onTargetCrashed(eventListener: EventHandler<TargetCrashed>): EventListener

  @EventName("targetInfoChanged")
  public fun onTargetInfoChanged(eventListener: EventHandler<TargetInfoChanged>): EventListener
}
