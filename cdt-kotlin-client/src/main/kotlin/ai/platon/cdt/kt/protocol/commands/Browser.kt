@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.browser.DownloadProgress
import ai.platon.cdt.kt.protocol.events.browser.DownloadWillBegin
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.browser.Bounds
import ai.platon.cdt.kt.protocol.types.browser.BrowserCommandId
import ai.platon.cdt.kt.protocol.types.browser.Histogram
import ai.platon.cdt.kt.protocol.types.browser.PermissionDescriptor
import ai.platon.cdt.kt.protocol.types.browser.PermissionSetting
import ai.platon.cdt.kt.protocol.types.browser.PermissionType
import ai.platon.cdt.kt.protocol.types.browser.PrivacySandboxAPI
import ai.platon.cdt.kt.protocol.types.browser.SetDownloadBehaviorBehavior
import ai.platon.cdt.kt.protocol.types.browser.Version
import ai.platon.cdt.kt.protocol.types.browser.WindowForTarget
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * The Browser domain defines methods and events for browser managing.
 */
interface Browser {
  /**
   * Set permission settings for given embedding and embedded origins.
   * @param permission Descriptor of permission to override.
   * @param setting Setting of the permission.
   * @param origin Embedding origin the permission applies to, all origins if not specified.
   * @param embeddedOrigin Embedded origin the permission applies to. It is ignored unless the embedding origin is
   * present and valid. If the embedding origin is provided but the embedded origin isn't, the
   * embedding origin is used as the embedded origin.
   * @param browserContextId Context to override. When omitted, default browser context is used.
   */
  @Experimental
  suspend fun setPermission(
    @ParamName("permission") permission: PermissionDescriptor,
    @ParamName("setting") setting: PermissionSetting,
    @ParamName("origin") @Optional origin: String? = null,
    @ParamName("embeddedOrigin") @Optional embeddedOrigin: String? = null,
    @ParamName("browserContextId") @Optional browserContextId: String? = null,
  )

  @Experimental
  suspend fun setPermission(@ParamName("permission") permission: PermissionDescriptor, @ParamName("setting") setting: PermissionSetting) {
    return setPermission(permission, setting, null, null, null)
  }

  /**
   * Grant specific permissions to the given origin and reject all others. Deprecated. Use
   * setPermission instead.
   * @param permissions
   * @param origin Origin the permission applies to, all origins if not specified.
   * @param browserContextId BrowserContext to override permissions. When omitted, default browser context is used.
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun grantPermissions(
    @ParamName("permissions") permissions: List<PermissionType>,
    @ParamName("origin") @Optional origin: String? = null,
    @ParamName("browserContextId") @Optional browserContextId: String? = null,
  )

  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun grantPermissions(@ParamName("permissions") permissions: List<PermissionType>) {
    return grantPermissions(permissions, null, null)
  }

  /**
   * Reset all permission management for all origins.
   * @param browserContextId BrowserContext to reset permissions. When omitted, default browser context is used.
   */
  suspend fun resetPermissions(@ParamName("browserContextId") @Optional browserContextId: String? = null)

  suspend fun resetPermissions() {
    return resetPermissions(null)
  }

  /**
   * Set the behavior when downloading a file.
   * @param behavior Whether to allow all or deny all download requests, or use default Chrome behavior if
   * available (otherwise deny). |allowAndName| allows download and names files according to
   * their download guids.
   * @param browserContextId BrowserContext to set download behavior. When omitted, default browser context is used.
   * @param downloadPath The default path to save downloaded files to. This is required if behavior is set to 'allow'
   * or 'allowAndName'.
   * @param eventsEnabled Whether to emit download events (defaults to false).
   */
  @Experimental
  suspend fun setDownloadBehavior(
    @ParamName("behavior") behavior: SetDownloadBehaviorBehavior,
    @ParamName("browserContextId") @Optional browserContextId: String? = null,
    @ParamName("downloadPath") @Optional downloadPath: String? = null,
    @ParamName("eventsEnabled") @Optional eventsEnabled: Boolean? = null,
  )

  @Experimental
  suspend fun setDownloadBehavior(@ParamName("behavior") behavior: SetDownloadBehaviorBehavior) {
    return setDownloadBehavior(behavior, null, null, null)
  }

  /**
   * Cancel a download if in progress
   * @param guid Global unique identifier of the download.
   * @param browserContextId BrowserContext to perform the action in. When omitted, default browser context is used.
   */
  @Experimental
  suspend fun cancelDownload(@ParamName("guid") guid: String, @ParamName("browserContextId") @Optional browserContextId: String? = null)

  @Experimental
  suspend fun cancelDownload(@ParamName("guid") guid: String) {
    return cancelDownload(guid, null)
  }

  /**
   * Close browser gracefully.
   */
  suspend fun close()

  /**
   * Crashes browser on the main thread.
   */
  @Experimental
  suspend fun crash()

  /**
   * Crashes GPU process.
   */
  @Experimental
  suspend fun crashGpuProcess()

  /**
   * Returns version information.
   */
  suspend fun getVersion(): Version

  /**
   * Returns the command line switches for the browser process if, and only if
   * --enable-automation is on the commandline.
   */
  @Experimental
  @Returns("arguments")
  @ReturnTypeParameter(String::class)
  suspend fun getBrowserCommandLine(): List<String>

  /**
   * Get Chrome histograms.
   * @param query Requested substring in name. Only histograms which have query as a
   * substring in their name are extracted. An empty or absent query returns
   * all histograms.
   * @param delta If true, retrieve delta since last delta call.
   */
  @Experimental
  @Returns("histograms")
  @ReturnTypeParameter(Histogram::class)
  suspend fun getHistograms(@ParamName("query") @Optional query: String? = null, @ParamName("delta") @Optional delta: Boolean? = null): List<Histogram>

  @Experimental
  @Returns("histograms")
  @ReturnTypeParameter(Histogram::class)
  suspend fun getHistograms(): List<Histogram> {
    return getHistograms(null, null)
  }

  /**
   * Get a Chrome histogram by name.
   * @param name Requested histogram name.
   * @param delta If true, retrieve delta since last delta call.
   */
  @Experimental
  @Returns("histogram")
  suspend fun getHistogram(@ParamName("name") name: String, @ParamName("delta") @Optional delta: Boolean? = null): Histogram

  @Experimental
  @Returns("histogram")
  suspend fun getHistogram(@ParamName("name") name: String): Histogram {
    return getHistogram(name, null)
  }

  /**
   * Get position and size of the browser window.
   * @param windowId Browser window id.
   */
  @Experimental
  @Returns("bounds")
  suspend fun getWindowBounds(@ParamName("windowId") windowId: Int): Bounds

  /**
   * Get the browser window that contains the devtools target.
   * @param targetId Devtools agent host id. If called as a part of the session, associated targetId is used.
   */
  @Experimental
  suspend fun getWindowForTarget(@ParamName("targetId") @Optional targetId: String? = null): WindowForTarget

  @Experimental
  suspend fun getWindowForTarget(): WindowForTarget {
    return getWindowForTarget(null)
  }

  /**
   * Set position and/or size of the browser window.
   * @param windowId Browser window id.
   * @param bounds New window bounds. The 'minimized', 'maximized' and 'fullscreen' states cannot be combined
   * with 'left', 'top', 'width' or 'height'. Leaves unspecified fields unchanged.
   */
  @Experimental
  suspend fun setWindowBounds(@ParamName("windowId") windowId: Int, @ParamName("bounds") bounds: Bounds)

  /**
   * Set size of the browser contents resizing browser window as necessary.
   * @param windowId Browser window id.
   * @param width The window contents width in DIP. Assumes current width if omitted.
   * Must be specified if 'height' is omitted.
   * @param height The window contents height in DIP. Assumes current height if omitted.
   * Must be specified if 'width' is omitted.
   */
  @Experimental
  suspend fun setContentsSize(
    @ParamName("windowId") windowId: Int,
    @ParamName("width") @Optional width: Int? = null,
    @ParamName("height") @Optional height: Int? = null,
  )

  @Experimental
  suspend fun setContentsSize(@ParamName("windowId") windowId: Int) {
    return setContentsSize(windowId, null, null)
  }

  /**
   * Set dock tile details, platform-specific.
   * @param badgeLabel
   * @param image Png encoded image. (Encoded as a base64 string when passed over JSON)
   */
  @Experimental
  suspend fun setDockTile(@ParamName("badgeLabel") @Optional badgeLabel: String? = null, @ParamName("image") @Optional image: String? = null)

  @Experimental
  suspend fun setDockTile() {
    return setDockTile(null, null)
  }

  /**
   * Invoke custom browser commands used by telemetry.
   * @param commandId
   */
  @Experimental
  suspend fun executeBrowserCommand(@ParamName("commandId") commandId: BrowserCommandId)

  /**
   * Allows a site to use privacy sandbox features that require enrollment
   * without the site actually being enrolled. Only supported on page targets.
   * @param url
   */
  suspend fun addPrivacySandboxEnrollmentOverride(@ParamName("url") url: String)

  /**
   * Configures encryption keys used with a given privacy sandbox API to talk
   * to a trusted coordinator.  Since this is intended for test automation only,
   * coordinatorOrigin must be a .test domain. No existing coordinator
   * configuration for the origin may exist.
   * @param api
   * @param coordinatorOrigin
   * @param keyConfig
   * @param browserContextId BrowserContext to perform the action in. When omitted, default browser
   * context is used.
   */
  suspend fun addPrivacySandboxCoordinatorKeyConfig(
    @ParamName("api") api: PrivacySandboxAPI,
    @ParamName("coordinatorOrigin") coordinatorOrigin: String,
    @ParamName("keyConfig") keyConfig: String,
    @ParamName("browserContextId") @Optional browserContextId: String? = null,
  )

  suspend fun addPrivacySandboxCoordinatorKeyConfig(
    @ParamName("api") api: PrivacySandboxAPI,
    @ParamName("coordinatorOrigin") coordinatorOrigin: String,
    @ParamName("keyConfig") keyConfig: String,
  ) {
    return addPrivacySandboxCoordinatorKeyConfig(api, coordinatorOrigin, keyConfig, null)
  }

  @EventName("downloadWillBegin")
  @Experimental
  fun onDownloadWillBegin(eventListener: EventHandler<DownloadWillBegin>): EventListener

  @EventName("downloadWillBegin")
  @Experimental
  fun onDownloadWillBegin(eventListener: suspend (DownloadWillBegin) -> Unit): EventListener

  @EventName("downloadProgress")
  @Experimental
  fun onDownloadProgress(eventListener: EventHandler<DownloadProgress>): EventListener

  @EventName("downloadProgress")
  @Experimental
  fun onDownloadProgress(eventListener: suspend (DownloadProgress) -> Unit): EventListener
}
