@file:Suppress("unused")
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
import ai.platon.cdt.kt.protocol.types.target.BrowserContexts
import ai.platon.cdt.kt.protocol.types.target.FilterEntry
import ai.platon.cdt.kt.protocol.types.target.RemoteLocation
import ai.platon.cdt.kt.protocol.types.target.TargetInfo
import ai.platon.cdt.kt.protocol.types.target.WindowState
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * Supports additional targets discovery and allows to attach to them.
 */
interface Target {
  /**
   * Activates (focuses) the target.
   * @param targetId
   */
  suspend fun activateTarget(@ParamName("targetId") targetId: String)

  /**
   * Attaches to the target with given id.
   * @param targetId
   * @param flatten Enables "flat" access to the session via specifying sessionId attribute in the commands.
   * We plan to make this the default, deprecate non-flattened mode,
   * and eventually retire it. See crbug.com/991325.
   */
  @Returns("sessionId")
  suspend fun attachToTarget(@ParamName("targetId") targetId: String, @ParamName("flatten") @Optional flatten: Boolean? = null): String

  @Returns("sessionId")
  suspend fun attachToTarget(@ParamName("targetId") targetId: String): String {
    return attachToTarget(targetId, null)
  }

  /**
   * Attaches to the browser target, only uses flat sessionId mode.
   */
  @Experimental
  @Returns("sessionId")
  suspend fun attachToBrowserTarget(): String

  /**
   * Closes the target. If the target is a page that gets closed too.
   * @param targetId
   */
  @Returns("success")
  suspend fun closeTarget(@ParamName("targetId") targetId: String): Boolean

  /**
   * Inject object to the target's main frame that provides a communication
   * channel with browser target.
   *
   * Injected object will be available as `window[bindingName]`.
   *
   * The object has the following API:
   * - `binding.send(json)` - a method to send messages over the remote debugging protocol
   * - `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
   * @param targetId
   * @param bindingName Binding name, 'cdp' if not specified.
   * @param inheritPermissions If true, inherits the current root session's permissions (default: false).
   */
  @Experimental
  suspend fun exposeDevToolsProtocol(
    @ParamName("targetId") targetId: String,
    @ParamName("bindingName") @Optional bindingName: String? = null,
    @ParamName("inheritPermissions") @Optional inheritPermissions: Boolean? = null,
  )

  @Experimental
  suspend fun exposeDevToolsProtocol(@ParamName("targetId") targetId: String) {
    return exposeDevToolsProtocol(targetId, null, null)
  }

  /**
   * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than
   * one.
   * @param disposeOnDetach If specified, disposes this context when debugging session disconnects.
   * @param proxyServer Proxy server, similar to the one passed to --proxy-server
   * @param proxyBypassList Proxy bypass list, similar to the one passed to --proxy-bypass-list
   * @param originsWithUniversalNetworkAccess An optional list of origins to grant unlimited cross-origin access to.
   * Parts of the URL other than those constituting origin are ignored.
   */
  @Returns("browserContextId")
  suspend fun createBrowserContext(
    @ParamName("disposeOnDetach") @Optional @Experimental disposeOnDetach: Boolean? = null,
    @ParamName("proxyServer") @Optional @Experimental proxyServer: String? = null,
    @ParamName("proxyBypassList") @Optional @Experimental proxyBypassList: String? = null,
    @ParamName("originsWithUniversalNetworkAccess") @Optional @Experimental originsWithUniversalNetworkAccess: List<String>? = null,
  ): String

  @Returns("browserContextId")
  suspend fun createBrowserContext(): String {
    return createBrowserContext(null, null, null, null)
  }

  /**
   * Returns all browser contexts created with `Target.createBrowserContext` method.
   */
  suspend fun getBrowserContexts(): BrowserContexts

  /**
   * Creates a new page.
   * @param url The initial URL the page will be navigated to. An empty string indicates about:blank.
   * @param left Frame left origin in DIP (requires newWindow to be true or headless shell).
   * @param top Frame top origin in DIP (requires newWindow to be true or headless shell).
   * @param width Frame width in DIP (requires newWindow to be true or headless shell).
   * @param height Frame height in DIP (requires newWindow to be true or headless shell).
   * @param windowState Frame window state (requires newWindow to be true or headless shell).
   * Default is normal.
   * @param browserContextId The browser context to create the page in.
   * @param enableBeginFrameControl Whether BeginFrames for this target will be controlled via DevTools (headless shell only,
   * not supported on MacOS yet, false by default).
   * @param newWindow Whether to create a new Window or Tab (false by default, not supported by headless shell).
   * @param background Whether to create the target in background or foreground (false by default, not supported
   * by headless shell).
   * @param forTab Whether to create the target of type "tab".
   * @param hidden Whether to create a hidden target. The hidden target is observable via protocol, but not
   * present in the tab UI strip. Cannot be created with `forTab: true`, `newWindow: true` or
   * `background: false`. The life-time of the tab is limited to the life-time of the session.
   * @param focus If specified, the option is used to determine if the new target should
   * be focused or not. By default, the focus behavior depends on the
   * value of the background field. For example, background=false and focus=false
   * will result in the target tab being opened but the browser window remain
   * unchanged (if it was in the background, it will remain in the background)
   * and background=false with focus=undefined will result in the window being focused.
   * Using background: true and focus: true is not supported and will result in an error.
   */
  @Returns("targetId")
  suspend fun createTarget(
    @ParamName("url") url: String,
    @ParamName("left") @Optional @Experimental left: Int? = null,
    @ParamName("top") @Optional @Experimental top: Int? = null,
    @ParamName("width") @Optional width: Int? = null,
    @ParamName("height") @Optional height: Int? = null,
    @ParamName("windowState") @Optional windowState: WindowState? = null,
    @ParamName("browserContextId") @Optional @Experimental browserContextId: String? = null,
    @ParamName("enableBeginFrameControl") @Optional @Experimental enableBeginFrameControl: Boolean? = null,
    @ParamName("newWindow") @Optional newWindow: Boolean? = null,
    @ParamName("background") @Optional background: Boolean? = null,
    @ParamName("forTab") @Optional @Experimental forTab: Boolean? = null,
    @ParamName("hidden") @Optional @Experimental hidden: Boolean? = null,
    @ParamName("focus") @Optional @Experimental focus: Boolean? = null,
  ): String

  @Returns("targetId")
  suspend fun createTarget(@ParamName("url") url: String): String {
    return createTarget(url, null, null, null, null, null, null, null, null, null, null, null, null)
  }

  /**
   * Detaches session with given id.
   * @param sessionId Session to detach.
   * @param targetId Deprecated.
   */
  suspend fun detachFromTarget(@ParamName("sessionId") @Optional sessionId: String? = null, @ParamName("targetId") @Optional targetId: String? = null)

  suspend fun detachFromTarget() {
    return detachFromTarget(null, null)
  }

  /**
   * Deletes a BrowserContext. All the belonging pages will be closed without calling their
   * beforeunload hooks.
   * @param browserContextId
   */
  suspend fun disposeBrowserContext(@ParamName("browserContextId") browserContextId: String)

  /**
   * Returns information about a target.
   * @param targetId
   */
  @Experimental
  @Returns("targetInfo")
  suspend fun getTargetInfo(@ParamName("targetId") @Optional targetId: String? = null): TargetInfo

  @Experimental
  @Returns("targetInfo")
  suspend fun getTargetInfo(): TargetInfo {
    return getTargetInfo(null)
  }

  /**
   * Retrieves a list of available targets.
   * @param filter Only targets matching filter will be reported. If filter is not specified
   * and target discovery is currently enabled, a filter used for target discovery
   * is used for consistency.
   */
  @Returns("targetInfos")
  @ReturnTypeParameter(TargetInfo::class)
  suspend fun getTargets(@ParamName("filter") @Optional @Experimental filter: List<FilterEntry>? = null): List<TargetInfo>

  @Returns("targetInfos")
  @ReturnTypeParameter(TargetInfo::class)
  suspend fun getTargets(): List<TargetInfo> {
    return getTargets(null)
  }

  /**
   * Sends protocol message over session with given id.
   * Consider using flat mode instead; see commands attachToTarget, setAutoAttach,
   * and crbug.com/991325.
   * @param message
   * @param sessionId Identifier of the session.
   * @param targetId Deprecated.
   */
  @Deprecated("Deprecated by protocol")
  suspend fun sendMessageToTarget(
    @ParamName("message") message: String,
    @ParamName("sessionId") @Optional sessionId: String? = null,
    @ParamName("targetId") @Optional targetId: String? = null,
  )

  @Deprecated("Deprecated by protocol")
  suspend fun sendMessageToTarget(@ParamName("message") message: String) {
    return sendMessageToTarget(message, null, null)
  }

  /**
   * Controls whether to automatically attach to new targets which are considered
   * to be directly related to this one (for example, iframes or workers).
   * When turned on, attaches to all existing related targets as well. When turned off,
   * automatically detaches from all currently attached targets.
   * This also clears all targets added by `autoAttachRelated` from the list of targets to watch
   * for creation of related targets.
   * You might want to call this recursively for auto-attached targets to attach
   * to all available targets.
   * @param autoAttach Whether to auto-attach to related targets.
   * @param waitForDebuggerOnStart Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger`
   * to run paused targets.
   * @param flatten Enables "flat" access to the session via specifying sessionId attribute in the commands.
   * We plan to make this the default, deprecate non-flattened mode,
   * and eventually retire it. See crbug.com/991325.
   * @param filter Only targets matching filter will be attached.
   */
  suspend fun setAutoAttach(
    @ParamName("autoAttach") autoAttach: Boolean,
    @ParamName("waitForDebuggerOnStart") waitForDebuggerOnStart: Boolean,
    @ParamName("flatten") @Optional @Experimental flatten: Boolean? = null,
    @ParamName("filter") @Optional @Experimental filter: List<FilterEntry>? = null,
  )

  suspend fun setAutoAttach(@ParamName("autoAttach") autoAttach: Boolean, @ParamName("waitForDebuggerOnStart") waitForDebuggerOnStart: Boolean) {
    return setAutoAttach(autoAttach, waitForDebuggerOnStart, null, null)
  }

  /**
   * Adds the specified target to the list of targets that will be monitored for any related target
   * creation (such as child frames, child workers and new versions of service worker) and reported
   * through `attachedToTarget`. The specified target is also auto-attached.
   * This cancels the effect of any previous `setAutoAttach` and is also cancelled by subsequent
   * `setAutoAttach`. Only available at the Browser target.
   * @param targetId
   * @param waitForDebuggerOnStart Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger`
   * to run paused targets.
   * @param filter Only targets matching filter will be attached.
   */
  @Experimental
  suspend fun autoAttachRelated(
    @ParamName("targetId") targetId: String,
    @ParamName("waitForDebuggerOnStart") waitForDebuggerOnStart: Boolean,
    @ParamName("filter") @Optional @Experimental filter: List<FilterEntry>? = null,
  )

  @Experimental
  suspend fun autoAttachRelated(@ParamName("targetId") targetId: String, @ParamName("waitForDebuggerOnStart") waitForDebuggerOnStart: Boolean) {
    return autoAttachRelated(targetId, waitForDebuggerOnStart, null)
  }

  /**
   * Controls whether to discover available targets and notify via
   * `targetCreated/targetInfoChanged/targetDestroyed` events.
   * @param discover Whether to discover available targets.
   * @param filter Only targets matching filter will be attached. If `discover` is false,
   * `filter` must be omitted or empty.
   */
  suspend fun setDiscoverTargets(@ParamName("discover") discover: Boolean, @ParamName("filter") @Optional @Experimental filter: List<FilterEntry>? = null)

  suspend fun setDiscoverTargets(@ParamName("discover") discover: Boolean) {
    return setDiscoverTargets(discover, null)
  }

  /**
   * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to
   * `true`.
   * @param locations List of remote locations.
   */
  @Experimental
  suspend fun setRemoteLocations(@ParamName("locations") locations: List<RemoteLocation>)

  /**
   * Gets the targetId of the DevTools page target opened for the given target
   * (if any).
   * @param targetId Page or tab target ID.
   */
  @Experimental
  @Returns("targetId")
  suspend fun getDevToolsTarget(@ParamName("targetId") targetId: String): String?

  /**
   * Opens a DevTools window for the target.
   * @param targetId This can be the page or tab target ID.
   * @param panelId The id of the panel we want DevTools to open initially. Currently
   * supported panels are elements, console, network, sources, resources,
   * timeline, chrome-recorder, heap-profiler, lighthouse, and security.
   */
  @Experimental
  @Returns("targetId")
  suspend fun openDevTools(@ParamName("targetId") targetId: String, @ParamName("panelId") @Optional panelId: String? = null): String

  @Experimental
  @Returns("targetId")
  suspend fun openDevTools(@ParamName("targetId") targetId: String): String {
    return openDevTools(targetId, null)
  }

  @EventName("attachedToTarget")
  @Experimental
  fun onAttachedToTarget(eventListener: EventHandler<AttachedToTarget>): EventListener

  @EventName("attachedToTarget")
  @Experimental
  fun onAttachedToTarget(eventListener: suspend (AttachedToTarget) -> Unit): EventListener

  @EventName("detachedFromTarget")
  @Experimental
  fun onDetachedFromTarget(eventListener: EventHandler<DetachedFromTarget>): EventListener

  @EventName("detachedFromTarget")
  @Experimental
  fun onDetachedFromTarget(eventListener: suspend (DetachedFromTarget) -> Unit): EventListener

  @EventName("receivedMessageFromTarget")
  fun onReceivedMessageFromTarget(eventListener: EventHandler<ReceivedMessageFromTarget>): EventListener

  @EventName("receivedMessageFromTarget")
  fun onReceivedMessageFromTarget(eventListener: suspend (ReceivedMessageFromTarget) -> Unit): EventListener

  @EventName("targetCreated")
  fun onTargetCreated(eventListener: EventHandler<TargetCreated>): EventListener

  @EventName("targetCreated")
  fun onTargetCreated(eventListener: suspend (TargetCreated) -> Unit): EventListener

  @EventName("targetDestroyed")
  fun onTargetDestroyed(eventListener: EventHandler<TargetDestroyed>): EventListener

  @EventName("targetDestroyed")
  fun onTargetDestroyed(eventListener: suspend (TargetDestroyed) -> Unit): EventListener

  @EventName("targetCrashed")
  fun onTargetCrashed(eventListener: EventHandler<TargetCrashed>): EventListener

  @EventName("targetCrashed")
  fun onTargetCrashed(eventListener: suspend (TargetCrashed) -> Unit): EventListener

  @EventName("targetInfoChanged")
  fun onTargetInfoChanged(eventListener: EventHandler<TargetInfoChanged>): EventListener

  @EventName("targetInfoChanged")
  fun onTargetInfoChanged(eventListener: suspend (TargetInfoChanged) -> Unit): EventListener
}
