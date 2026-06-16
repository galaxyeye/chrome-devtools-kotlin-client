@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.page.BackForwardCacheNotUsed
import ai.platon.cdt.kt.protocol.events.page.CompilationCacheProduced
import ai.platon.cdt.kt.protocol.events.page.DocumentOpened
import ai.platon.cdt.kt.protocol.events.page.DomContentEventFired
import ai.platon.cdt.kt.protocol.events.page.DownloadProgress
import ai.platon.cdt.kt.protocol.events.page.DownloadWillBegin
import ai.platon.cdt.kt.protocol.events.page.FileChooserOpened
import ai.platon.cdt.kt.protocol.events.page.FrameAttached
import ai.platon.cdt.kt.protocol.events.page.FrameClearedScheduledNavigation
import ai.platon.cdt.kt.protocol.events.page.FrameDetached
import ai.platon.cdt.kt.protocol.events.page.FrameNavigated
import ai.platon.cdt.kt.protocol.events.page.FrameRequestedNavigation
import ai.platon.cdt.kt.protocol.events.page.FrameResized
import ai.platon.cdt.kt.protocol.events.page.FrameScheduledNavigation
import ai.platon.cdt.kt.protocol.events.page.FrameStartedLoading
import ai.platon.cdt.kt.protocol.events.page.FrameStartedNavigating
import ai.platon.cdt.kt.protocol.events.page.FrameStoppedLoading
import ai.platon.cdt.kt.protocol.events.page.FrameSubtreeWillBeDetached
import ai.platon.cdt.kt.protocol.events.page.InterstitialHidden
import ai.platon.cdt.kt.protocol.events.page.InterstitialShown
import ai.platon.cdt.kt.protocol.events.page.JavascriptDialogClosed
import ai.platon.cdt.kt.protocol.events.page.JavascriptDialogOpening
import ai.platon.cdt.kt.protocol.events.page.LifecycleEvent
import ai.platon.cdt.kt.protocol.events.page.LoadEventFired
import ai.platon.cdt.kt.protocol.events.page.NavigatedWithinDocument
import ai.platon.cdt.kt.protocol.events.page.ScreencastFrame
import ai.platon.cdt.kt.protocol.events.page.ScreencastVisibilityChanged
import ai.platon.cdt.kt.protocol.events.page.WindowOpen
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.debugger.SearchMatch
import ai.platon.cdt.kt.protocol.types.network.AdAncestry
import ai.platon.cdt.kt.protocol.types.page.AppId
import ai.platon.cdt.kt.protocol.types.page.AppManifest
import ai.platon.cdt.kt.protocol.types.page.CaptureScreenshotFormat
import ai.platon.cdt.kt.protocol.types.page.CaptureSnapshotFormat
import ai.platon.cdt.kt.protocol.types.page.CompilationCacheParams
import ai.platon.cdt.kt.protocol.types.page.FontFamilies
import ai.platon.cdt.kt.protocol.types.page.FontSizes
import ai.platon.cdt.kt.protocol.types.page.FrameResourceTree
import ai.platon.cdt.kt.protocol.types.page.FrameTree
import ai.platon.cdt.kt.protocol.types.page.InstallabilityError
import ai.platon.cdt.kt.protocol.types.page.LayoutMetrics
import ai.platon.cdt.kt.protocol.types.page.Navigate
import ai.platon.cdt.kt.protocol.types.page.NavigationHistory
import ai.platon.cdt.kt.protocol.types.page.OriginTrial
import ai.platon.cdt.kt.protocol.types.page.PermissionsPolicyFeatureState
import ai.platon.cdt.kt.protocol.types.page.PrintToPDF
import ai.platon.cdt.kt.protocol.types.page.PrintToPDFTransferMode
import ai.platon.cdt.kt.protocol.types.page.ReferrerPolicy
import ai.platon.cdt.kt.protocol.types.page.ResourceContent
import ai.platon.cdt.kt.protocol.types.page.ScriptFontFamilies
import ai.platon.cdt.kt.protocol.types.page.SetDownloadBehaviorBehavior
import ai.platon.cdt.kt.protocol.types.page.SetRPHRegistrationModeMode
import ai.platon.cdt.kt.protocol.types.page.SetSPCTransactionModeMode
import ai.platon.cdt.kt.protocol.types.page.SetWebLifecycleStateState
import ai.platon.cdt.kt.protocol.types.page.StartScreencastFormat
import ai.platon.cdt.kt.protocol.types.page.TransitionType
import ai.platon.cdt.kt.protocol.types.page.Viewport
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * Actions and events related to the inspected page belong to the page domain.
 */
interface Page {
  /**
   * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
   * @param scriptSource
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  @Returns("identifier")
  suspend fun addScriptToEvaluateOnLoad(@ParamName("scriptSource") scriptSource: String): String

  /**
   * Evaluates given script in every frame upon creation (before loading frame's scripts).
   * @param source
   * @param worldName If specified, creates an isolated world with the given name and evaluates given script in it.
   * This world name will be used as the ExecutionContextDescription::name when the corresponding
   * event is emitted.
   * @param includeCommandLineAPI Specifies whether command line API should be available to the script, defaults
   * to false.
   * @param runImmediately If true, runs the script immediately on existing execution contexts or worlds.
   * Default: false.
   */
  @Returns("identifier")
  suspend fun addScriptToEvaluateOnNewDocument(
    @ParamName("source") source: String,
    @ParamName("worldName") @Optional @Experimental worldName: String? = null,
    @ParamName("includeCommandLineAPI") @Optional @Experimental includeCommandLineAPI: Boolean? = null,
    @ParamName("runImmediately") @Optional @Experimental runImmediately: Boolean? = null,
  ): String

  @Returns("identifier")
  suspend fun addScriptToEvaluateOnNewDocument(@ParamName("source") source: String): String {
    return addScriptToEvaluateOnNewDocument(source, null, null, null)
  }

  /**
   * Brings page to front (activates tab).
   */
  suspend fun bringToFront()

  /**
   * Capture page screenshot.
   * @param format Image compression format (defaults to png).
   * @param quality Compression quality from range [0..100] (jpeg only).
   * @param clip Capture the screenshot of a given region only.
   * @param fromSurface Capture the screenshot from the surface, rather than the view. Defaults to true.
   * @param captureBeyondViewport Capture the screenshot beyond the viewport. Defaults to false.
   * @param optimizeForSpeed Optimize image encoding for speed, not for resulting size (defaults to false)
   */
  @Returns("data")
  suspend fun captureScreenshot(
    @ParamName("format") @Optional format: CaptureScreenshotFormat? = null,
    @ParamName("quality") @Optional quality: Int? = null,
    @ParamName("clip") @Optional clip: Viewport? = null,
    @ParamName("fromSurface") @Optional @Experimental fromSurface: Boolean? = null,
    @ParamName("captureBeyondViewport") @Optional @Experimental captureBeyondViewport: Boolean? = null,
    @ParamName("optimizeForSpeed") @Optional @Experimental optimizeForSpeed: Boolean? = null,
  ): String

  @Returns("data")
  suspend fun captureScreenshot(): String {
    return captureScreenshot(null, null, null, null, null, null)
  }

  /**
   * Returns a snapshot of the page as a string. For MHTML format, the serialization includes
   * iframes, shadow DOM, external resources, and element-inline styles.
   * @param format Format (defaults to mhtml).
   */
  @Experimental
  @Returns("data")
  suspend fun captureSnapshot(@ParamName("format") @Optional format: CaptureSnapshotFormat? = null): String

  @Experimental
  @Returns("data")
  suspend fun captureSnapshot(): String {
    return captureSnapshot(null)
  }

  /**
   * Creates an isolated world for the given frame.
   * @param frameId Id of the frame in which the isolated world should be created.
   * @param worldName An optional name which is reported in the Execution Context.
   * @param grantUniveralAccess Whether or not universal access should be granted to the isolated world. This is a powerful
   * option, use with caution.
   */
  @Returns("executionContextId")
  suspend fun createIsolatedWorld(
    @ParamName("frameId") frameId: String,
    @ParamName("worldName") @Optional worldName: String? = null,
    @ParamName("grantUniveralAccess") @Optional grantUniveralAccess: Boolean? = null,
  ): Int

  @Returns("executionContextId")
  suspend fun createIsolatedWorld(@ParamName("frameId") frameId: String): Int {
    return createIsolatedWorld(frameId, null, null)
  }

  /**
   * Disables page domain notifications.
   */
  suspend fun disable()

  /**
   * Enables page domain notifications.
   * @param enableFileChooserOpenedEvent If true, the `Page.fileChooserOpened` event will be emitted regardless of the state set by
   * `Page.setInterceptFileChooserDialog` command (default: false).
   */
  suspend fun enable(@ParamName("enableFileChooserOpenedEvent") @Optional @Experimental enableFileChooserOpenedEvent: Boolean? = null)

  suspend fun enable() {
    return enable(null)
  }

  /**
   * Gets the processed manifest for this current document.
   *   This API always waits for the manifest to be loaded.
   *   If manifestId is provided, and it does not match the manifest of the
   *     current document, this API errors out.
   *   If there is not a loaded page, this API errors out immediately.
   * @param manifestId
   */
  suspend fun getAppManifest(@ParamName("manifestId") @Optional manifestId: String? = null): AppManifest

  suspend fun getAppManifest(): AppManifest {
    return getAppManifest(null)
  }

  @Experimental
  @Returns("installabilityErrors")
  @ReturnTypeParameter(InstallabilityError::class)
  suspend fun getInstallabilityErrors(): List<InstallabilityError>

  /**
   * Deprecated because it's not guaranteed that the returned icon is in fact the one used for PWA installation.
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  @Returns("primaryIcon")
  suspend fun getManifestIcons(): String?

  /**
   * Returns the unique (PWA) app id.
   * Only returns values if the feature flag 'WebAppEnableManifestId' is enabled
   */
  @Experimental
  suspend fun getAppId(): AppId

  /**
   * @param frameId
   */
  @Experimental
  @Returns("adScriptAncestry")
  suspend fun getAdScriptAncestry(@ParamName("frameId") frameId: String): AdAncestry?

  /**
   * Returns present frame tree structure.
   */
  @Returns("frameTree")
  suspend fun getFrameTree(): FrameTree

  /**
   * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
   */
  suspend fun getLayoutMetrics(): LayoutMetrics

  /**
   * Returns navigation history for the current page.
   */
  suspend fun getNavigationHistory(): NavigationHistory

  /**
   * Resets navigation history for the current page.
   */
  suspend fun resetNavigationHistory()

  /**
   * Returns content of the given resource.
   * @param frameId Frame id to get resource for.
   * @param url URL of the resource to get content for.
   */
  @Experimental
  suspend fun getResourceContent(@ParamName("frameId") frameId: String, @ParamName("url") url: String): ResourceContent

  /**
   * Returns present frame / resource tree structure.
   */
  @Experimental
  @Returns("frameTree")
  suspend fun getResourceTree(): FrameResourceTree

  /**
   * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
   * @param accept Whether to accept or dismiss the dialog.
   * @param promptText The text to enter into the dialog prompt before accepting. Used only if this is a prompt
   * dialog.
   */
  suspend fun handleJavaScriptDialog(@ParamName("accept") accept: Boolean, @ParamName("promptText") @Optional promptText: String? = null)

  suspend fun handleJavaScriptDialog(@ParamName("accept") accept: Boolean) {
    return handleJavaScriptDialog(accept, null)
  }

  /**
   * Navigates current page to the given URL.
   * @param url URL to navigate the page to.
   * @param referrer Referrer URL.
   * @param transitionType Intended transition type.
   * @param frameId Frame id to navigate, if not specified navigates the top frame.
   * @param referrerPolicy Referrer-policy used for the navigation.
   */
  suspend fun navigate(
    @ParamName("url") url: String,
    @ParamName("referrer") @Optional referrer: String? = null,
    @ParamName("transitionType") @Optional transitionType: TransitionType? = null,
    @ParamName("frameId") @Optional frameId: String? = null,
    @ParamName("referrerPolicy") @Optional @Experimental referrerPolicy: ReferrerPolicy? = null,
  ): Navigate

  suspend fun navigate(@ParamName("url") url: String): Navigate {
    return navigate(url, null, null, null, null)
  }

  /**
   * Navigates current page to the given history entry.
   * @param entryId Unique id of the entry to navigate to.
   */
  suspend fun navigateToHistoryEntry(@ParamName("entryId") entryId: Int)

  /**
   * Print page as PDF.
   * @param landscape Paper orientation. Defaults to false.
   * @param displayHeaderFooter Display header and footer. Defaults to false.
   * @param printBackground Print background graphics. Defaults to false.
   * @param scale Scale of the webpage rendering. Defaults to 1.
   * @param paperWidth Paper width in inches. Defaults to 8.5 inches.
   * @param paperHeight Paper height in inches. Defaults to 11 inches.
   * @param marginTop Top margin in inches. Defaults to 1cm (~0.4 inches).
   * @param marginBottom Bottom margin in inches. Defaults to 1cm (~0.4 inches).
   * @param marginLeft Left margin in inches. Defaults to 1cm (~0.4 inches).
   * @param marginRight Right margin in inches. Defaults to 1cm (~0.4 inches).
   * @param pageRanges Paper ranges to print, one based, e.g., '1-5, 8, 11-13'. Pages are
   * printed in the document order, not in the order specified, and no
   * more than once.
   * Defaults to empty string, which implies the entire document is printed.
   * The page numbers are quietly capped to actual page count of the
   * document, and ranges beyond the end of the document are ignored.
   * If this results in no pages to print, an error is reported.
   * It is an error to specify a range with start greater than end.
   * @param headerTemplate HTML template for the print header. Should be valid HTML markup with following
   * classes used to inject printing values into them:
   * - `date`: formatted print date
   * - `title`: document title
   * - `url`: document location
   * - `pageNumber`: current page number
   * - `totalPages`: total pages in the document
   *
   * For example, `<span class=title></span>` would generate span containing the title.
   * @param footerTemplate HTML template for the print footer. Should use the same format as the `headerTemplate`.
   * @param preferCSSPageSize Whether or not to prefer page size as defined by css. Defaults to false,
   * in which case the content will be scaled to fit the paper size.
   * @param transferMode return as stream
   * @param generateTaggedPDF Whether or not to generate tagged (accessible) PDF. Defaults to embedder choice.
   * @param generateDocumentOutline Whether or not to embed the document outline into the PDF.
   */
  suspend fun printToPDF(
    @ParamName("landscape") @Optional landscape: Boolean? = null,
    @ParamName("displayHeaderFooter") @Optional displayHeaderFooter: Boolean? = null,
    @ParamName("printBackground") @Optional printBackground: Boolean? = null,
    @ParamName("scale") @Optional scale: Double? = null,
    @ParamName("paperWidth") @Optional paperWidth: Double? = null,
    @ParamName("paperHeight") @Optional paperHeight: Double? = null,
    @ParamName("marginTop") @Optional marginTop: Double? = null,
    @ParamName("marginBottom") @Optional marginBottom: Double? = null,
    @ParamName("marginLeft") @Optional marginLeft: Double? = null,
    @ParamName("marginRight") @Optional marginRight: Double? = null,
    @ParamName("pageRanges") @Optional pageRanges: String? = null,
    @ParamName("headerTemplate") @Optional headerTemplate: String? = null,
    @ParamName("footerTemplate") @Optional footerTemplate: String? = null,
    @ParamName("preferCSSPageSize") @Optional preferCSSPageSize: Boolean? = null,
    @ParamName("transferMode") @Optional @Experimental transferMode: PrintToPDFTransferMode? = null,
    @ParamName("generateTaggedPDF") @Optional @Experimental generateTaggedPDF: Boolean? = null,
    @ParamName("generateDocumentOutline") @Optional @Experimental generateDocumentOutline: Boolean? = null,
  ): PrintToPDF

  suspend fun printToPDF(): PrintToPDF {
    return printToPDF(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
  }

  /**
   * Reloads given page optionally ignoring the cache.
   * @param ignoreCache If true, browser cache is ignored (as if the user pressed Shift+refresh).
   * @param scriptToEvaluateOnLoad If set, the script will be injected into all frames of the inspected page after reload.
   * Argument will be ignored if reloading dataURL origin.
   * @param loaderId If set, an error will be thrown if the target page's main frame's
   * loader id does not match the provided id. This prevents accidentally
   * reloading an unintended target in case there's a racing navigation.
   */
  suspend fun reload(
    @ParamName("ignoreCache") @Optional ignoreCache: Boolean? = null,
    @ParamName("scriptToEvaluateOnLoad") @Optional scriptToEvaluateOnLoad: String? = null,
    @ParamName("loaderId") @Optional @Experimental loaderId: String? = null,
  )

  suspend fun reload() {
    return reload(null, null, null)
  }

  /**
   * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
   * @param identifier
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun removeScriptToEvaluateOnLoad(@ParamName("identifier") identifier: String)

  /**
   * Removes given script from the list.
   * @param identifier
   */
  suspend fun removeScriptToEvaluateOnNewDocument(@ParamName("identifier") identifier: String)

  /**
   * Acknowledges that a screencast frame has been received by the frontend.
   * @param sessionId Frame number.
   */
  @Experimental
  suspend fun screencastFrameAck(@ParamName("sessionId") sessionId: Int)

  /**
   * Searches for given string in resource content.
   * @param frameId Frame id for resource to search in.
   * @param url URL of the resource to search in.
   * @param query String to search for.
   * @param caseSensitive If true, search is case sensitive.
   * @param isRegex If true, treats string parameter as regex.
   */
  @Experimental
  @Returns("result")
  @ReturnTypeParameter(SearchMatch::class)
  suspend fun searchInResource(
    @ParamName("frameId") frameId: String,
    @ParamName("url") url: String,
    @ParamName("query") query: String,
    @ParamName("caseSensitive") @Optional caseSensitive: Boolean? = null,
    @ParamName("isRegex") @Optional isRegex: Boolean? = null,
  ): List<SearchMatch>

  @Experimental
  @Returns("result")
  @ReturnTypeParameter(SearchMatch::class)
  suspend fun searchInResource(
    @ParamName("frameId") frameId: String,
    @ParamName("url") url: String,
    @ParamName("query") query: String,
  ): List<SearchMatch> {
    return searchInResource(frameId, url, query, null, null)
  }

  /**
   * Enable Chrome's experimental ad filter on all sites.
   * @param enabled Whether to block ads.
   */
  @Experimental
  suspend fun setAdBlockingEnabled(@ParamName("enabled") enabled: Boolean)

  /**
   * Enable page Content Security Policy by-passing.
   * @param enabled Whether to bypass page CSP.
   */
  suspend fun setBypassCSP(@ParamName("enabled") enabled: Boolean)

  /**
   * Get Permissions Policy state on given frame.
   * @param frameId
   */
  @Experimental
  @Returns("states")
  @ReturnTypeParameter(PermissionsPolicyFeatureState::class)
  suspend fun getPermissionsPolicyState(@ParamName("frameId") frameId: String): List<PermissionsPolicyFeatureState>

  /**
   * Get Origin Trials on given frame.
   * @param frameId
   */
  @Experimental
  @Returns("originTrials")
  @ReturnTypeParameter(OriginTrial::class)
  suspend fun getOriginTrials(@ParamName("frameId") frameId: String): List<OriginTrial>

  /**
   * Set generic font families.
   * @param fontFamilies Specifies font families to set. If a font family is not specified, it won't be changed.
   * @param forScripts Specifies font families to set for individual scripts.
   */
  @Experimental
  suspend fun setFontFamilies(@ParamName("fontFamilies") fontFamilies: FontFamilies, @ParamName("forScripts") @Optional forScripts: List<ScriptFontFamilies>? = null)

  @Experimental
  suspend fun setFontFamilies(@ParamName("fontFamilies") fontFamilies: FontFamilies) {
    return setFontFamilies(fontFamilies, null)
  }

  /**
   * Set default font sizes.
   * @param fontSizes Specifies font sizes to set. If a font size is not specified, it won't be changed.
   */
  @Experimental
  suspend fun setFontSizes(@ParamName("fontSizes") fontSizes: FontSizes)

  /**
   * Sets given markup as the document's HTML.
   * @param frameId Frame id to set HTML for.
   * @param html HTML content to set.
   */
  suspend fun setDocumentContent(@ParamName("frameId") frameId: String, @ParamName("html") html: String)

  /**
   * Set the behavior when downloading a file.
   * @param behavior Whether to allow all or deny all download requests, or use default Chrome behavior if
   * available (otherwise deny).
   * @param downloadPath The default path to save downloaded files to. This is required if behavior is set to 'allow'
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun setDownloadBehavior(@ParamName("behavior") behavior: SetDownloadBehaviorBehavior, @ParamName("downloadPath") @Optional downloadPath: String? = null)

  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun setDownloadBehavior(@ParamName("behavior") behavior: SetDownloadBehaviorBehavior) {
    return setDownloadBehavior(behavior, null)
  }

  /**
   * Controls whether page will emit lifecycle events.
   * @param enabled If true, starts emitting lifecycle events.
   */
  suspend fun setLifecycleEventsEnabled(@ParamName("enabled") enabled: Boolean)

  /**
   * Starts sending each frame using the `screencastFrame` event.
   * @param format Image compression format.
   * @param quality Compression quality from range [0..100].
   * @param maxWidth Maximum screenshot width.
   * @param maxHeight Maximum screenshot height.
   * @param everyNthFrame Send every n-th frame.
   */
  @Experimental
  suspend fun startScreencast(
    @ParamName("format") @Optional format: StartScreencastFormat? = null,
    @ParamName("quality") @Optional quality: Int? = null,
    @ParamName("maxWidth") @Optional maxWidth: Int? = null,
    @ParamName("maxHeight") @Optional maxHeight: Int? = null,
    @ParamName("everyNthFrame") @Optional everyNthFrame: Int? = null,
  )

  @Experimental
  suspend fun startScreencast() {
    return startScreencast(null, null, null, null, null)
  }

  /**
   * Force the page stop all navigations and pending resource fetches.
   */
  suspend fun stopLoading()

  /**
   * Crashes renderer on the IO thread, generates minidumps.
   */
  @Experimental
  suspend fun crash()

  /**
   * Tries to close page, running its beforeunload hooks, if any.
   */
  suspend fun close()

  /**
   * Tries to update the web lifecycle state of the page.
   * It will transition the page to the given state according to:
   * https://github.com/WICG/web-lifecycle/
   * @param state Target lifecycle state
   */
  @Experimental
  suspend fun setWebLifecycleState(@ParamName("state") state: SetWebLifecycleStateState)

  /**
   * Stops sending each frame in the `screencastFrame`.
   */
  @Experimental
  suspend fun stopScreencast()

  /**
   * Requests backend to produce compilation cache for the specified scripts.
   * `scripts` are appended to the list of scripts for which the cache
   * would be produced. The list may be reset during page navigation.
   * When script with a matching URL is encountered, the cache is optionally
   * produced upon backend discretion, based on internal heuristics.
   * See also: `Page.compilationCacheProduced`.
   * @param scripts
   */
  @Experimental
  suspend fun produceCompilationCache(@ParamName("scripts") scripts: List<CompilationCacheParams>)

  /**
   * Seeds compilation cache for given url. Compilation cache does not survive
   * cross-process navigation.
   * @param url
   * @param data Base64-encoded data (Encoded as a base64 string when passed over JSON)
   */
  @Experimental
  suspend fun addCompilationCache(@ParamName("url") url: String, @ParamName("data") `data`: String)

  /**
   * Clears seeded compilation cache.
   */
  @Experimental
  suspend fun clearCompilationCache()

  /**
   * Sets the Secure Payment Confirmation transaction mode.
   * https://w3c.github.io/secure-payment-confirmation/#sctn-automation-set-spc-transaction-mode
   * @param mode
   */
  @Experimental
  suspend fun setSPCTransactionMode(@ParamName("mode") mode: SetSPCTransactionModeMode)

  /**
   * Extensions for Custom Handlers API:
   * https://html.spec.whatwg.org/multipage/system-state.html#rph-automation
   * @param mode
   */
  @Experimental
  suspend fun setRPHRegistrationMode(@ParamName("mode") mode: SetRPHRegistrationModeMode)

  /**
   * Generates a report for testing.
   * @param message Message to be displayed in the report.
   * @param group Specifies the endpoint group to deliver the report to.
   */
  @Experimental
  suspend fun generateTestReport(@ParamName("message") message: String, @ParamName("group") @Optional group: String? = null)

  @Experimental
  suspend fun generateTestReport(@ParamName("message") message: String) {
    return generateTestReport(message, null)
  }

  /**
   * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
   */
  @Experimental
  suspend fun waitForDebugger()

  /**
   * Intercept file chooser requests and transfer control to protocol clients.
   * When file chooser interception is enabled, native file chooser dialog is not shown.
   * Instead, a protocol event `Page.fileChooserOpened` is emitted.
   * @param enabled
   * @param cancel If true, cancels the dialog by emitting relevant events (if any)
   * in addition to not showing it if the interception is enabled
   * (default: false).
   */
  suspend fun setInterceptFileChooserDialog(@ParamName("enabled") enabled: Boolean, @ParamName("cancel") @Optional @Experimental cancel: Boolean? = null)

  suspend fun setInterceptFileChooserDialog(@ParamName("enabled") enabled: Boolean) {
    return setInterceptFileChooserDialog(enabled, null)
  }

  /**
   * Enable/disable prerendering manually.
   *
   * This command is a short-term solution for https://crbug.com/1440085.
   * See https://docs.google.com/document/d/12HVmFxYj5Jc-eJr5OmWsa2bqTJsbgGLKI6ZIyx0_wpA
   * for more details.
   *
   * TODO(https://crbug.com/1440085): Remove this once Puppeteer supports tab targets.
   * @param isAllowed
   */
  @Experimental
  suspend fun setPrerenderingAllowed(@ParamName("isAllowed") isAllowed: Boolean)

  /**
   * Get the annotated page content for the main frame.
   * This is an experimental command that is subject to change.
   * @param includeActionableInformation Whether to include actionable information. Defaults to true.
   */
  @Experimental
  @Returns("content")
  suspend fun getAnnotatedPageContent(@ParamName("includeActionableInformation") @Optional includeActionableInformation: Boolean? = null): String

  @Experimental
  @Returns("content")
  suspend fun getAnnotatedPageContent(): String {
    return getAnnotatedPageContent(null)
  }

  @EventName("domContentEventFired")
  fun onDomContentEventFired(eventListener: EventHandler<DomContentEventFired>): EventListener

  @EventName("domContentEventFired")
  fun onDomContentEventFired(eventListener: suspend (DomContentEventFired) -> Unit): EventListener

  @EventName("fileChooserOpened")
  fun onFileChooserOpened(eventListener: EventHandler<FileChooserOpened>): EventListener

  @EventName("fileChooserOpened")
  fun onFileChooserOpened(eventListener: suspend (FileChooserOpened) -> Unit): EventListener

  @EventName("frameAttached")
  fun onFrameAttached(eventListener: EventHandler<FrameAttached>): EventListener

  @EventName("frameAttached")
  fun onFrameAttached(eventListener: suspend (FrameAttached) -> Unit): EventListener

  @EventName("frameClearedScheduledNavigation")
  @Deprecated("Deprecated by protocol")
  fun onFrameClearedScheduledNavigation(eventListener: EventHandler<FrameClearedScheduledNavigation>): EventListener

  @EventName("frameClearedScheduledNavigation")
  @Deprecated("Deprecated by protocol")
  fun onFrameClearedScheduledNavigation(eventListener: suspend (FrameClearedScheduledNavigation) -> Unit): EventListener

  @EventName("frameDetached")
  fun onFrameDetached(eventListener: EventHandler<FrameDetached>): EventListener

  @EventName("frameDetached")
  fun onFrameDetached(eventListener: suspend (FrameDetached) -> Unit): EventListener

  @EventName("frameSubtreeWillBeDetached")
  @Experimental
  fun onFrameSubtreeWillBeDetached(eventListener: EventHandler<FrameSubtreeWillBeDetached>): EventListener

  @EventName("frameSubtreeWillBeDetached")
  @Experimental
  fun onFrameSubtreeWillBeDetached(eventListener: suspend (FrameSubtreeWillBeDetached) -> Unit): EventListener

  @EventName("frameNavigated")
  fun onFrameNavigated(eventListener: EventHandler<FrameNavigated>): EventListener

  @EventName("frameNavigated")
  fun onFrameNavigated(eventListener: suspend (FrameNavigated) -> Unit): EventListener

  @EventName("documentOpened")
  @Experimental
  fun onDocumentOpened(eventListener: EventHandler<DocumentOpened>): EventListener

  @EventName("documentOpened")
  @Experimental
  fun onDocumentOpened(eventListener: suspend (DocumentOpened) -> Unit): EventListener

  @EventName("frameResized")
  @Experimental
  fun onFrameResized(eventListener: EventHandler<FrameResized>): EventListener

  @EventName("frameResized")
  @Experimental
  fun onFrameResized(eventListener: suspend (FrameResized) -> Unit): EventListener

  @EventName("frameStartedNavigating")
  @Experimental
  fun onFrameStartedNavigating(eventListener: EventHandler<FrameStartedNavigating>): EventListener

  @EventName("frameStartedNavigating")
  @Experimental
  fun onFrameStartedNavigating(eventListener: suspend (FrameStartedNavigating) -> Unit): EventListener

  @EventName("frameRequestedNavigation")
  @Experimental
  fun onFrameRequestedNavigation(eventListener: EventHandler<FrameRequestedNavigation>): EventListener

  @EventName("frameRequestedNavigation")
  @Experimental
  fun onFrameRequestedNavigation(eventListener: suspend (FrameRequestedNavigation) -> Unit): EventListener

  @EventName("frameScheduledNavigation")
  @Deprecated("Deprecated by protocol")
  fun onFrameScheduledNavigation(eventListener: EventHandler<FrameScheduledNavigation>): EventListener

  @EventName("frameScheduledNavigation")
  @Deprecated("Deprecated by protocol")
  fun onFrameScheduledNavigation(eventListener: suspend (FrameScheduledNavigation) -> Unit): EventListener

  @EventName("frameStartedLoading")
  @Experimental
  fun onFrameStartedLoading(eventListener: EventHandler<FrameStartedLoading>): EventListener

  @EventName("frameStartedLoading")
  @Experimental
  fun onFrameStartedLoading(eventListener: suspend (FrameStartedLoading) -> Unit): EventListener

  @EventName("frameStoppedLoading")
  @Experimental
  fun onFrameStoppedLoading(eventListener: EventHandler<FrameStoppedLoading>): EventListener

  @EventName("frameStoppedLoading")
  @Experimental
  fun onFrameStoppedLoading(eventListener: suspend (FrameStoppedLoading) -> Unit): EventListener

  @EventName("downloadWillBegin")
  @Deprecated("Deprecated by protocol")
  @Experimental
  fun onDownloadWillBegin(eventListener: EventHandler<DownloadWillBegin>): EventListener

  @EventName("downloadWillBegin")
  @Deprecated("Deprecated by protocol")
  @Experimental
  fun onDownloadWillBegin(eventListener: suspend (DownloadWillBegin) -> Unit): EventListener

  @EventName("downloadProgress")
  @Deprecated("Deprecated by protocol")
  @Experimental
  fun onDownloadProgress(eventListener: EventHandler<DownloadProgress>): EventListener

  @EventName("downloadProgress")
  @Deprecated("Deprecated by protocol")
  @Experimental
  fun onDownloadProgress(eventListener: suspend (DownloadProgress) -> Unit): EventListener

  @EventName("interstitialHidden")
  fun onInterstitialHidden(eventListener: EventHandler<InterstitialHidden>): EventListener

  @EventName("interstitialHidden")
  fun onInterstitialHidden(eventListener: suspend (InterstitialHidden) -> Unit): EventListener

  @EventName("interstitialShown")
  fun onInterstitialShown(eventListener: EventHandler<InterstitialShown>): EventListener

  @EventName("interstitialShown")
  fun onInterstitialShown(eventListener: suspend (InterstitialShown) -> Unit): EventListener

  @EventName("javascriptDialogClosed")
  fun onJavascriptDialogClosed(eventListener: EventHandler<JavascriptDialogClosed>): EventListener

  @EventName("javascriptDialogClosed")
  fun onJavascriptDialogClosed(eventListener: suspend (JavascriptDialogClosed) -> Unit): EventListener

  @EventName("javascriptDialogOpening")
  fun onJavascriptDialogOpening(eventListener: EventHandler<JavascriptDialogOpening>): EventListener

  @EventName("javascriptDialogOpening")
  fun onJavascriptDialogOpening(eventListener: suspend (JavascriptDialogOpening) -> Unit): EventListener

  @EventName("lifecycleEvent")
  fun onLifecycleEvent(eventListener: EventHandler<LifecycleEvent>): EventListener

  @EventName("lifecycleEvent")
  fun onLifecycleEvent(eventListener: suspend (LifecycleEvent) -> Unit): EventListener

  @EventName("backForwardCacheNotUsed")
  @Experimental
  fun onBackForwardCacheNotUsed(eventListener: EventHandler<BackForwardCacheNotUsed>): EventListener

  @EventName("backForwardCacheNotUsed")
  @Experimental
  fun onBackForwardCacheNotUsed(eventListener: suspend (BackForwardCacheNotUsed) -> Unit): EventListener

  @EventName("loadEventFired")
  fun onLoadEventFired(eventListener: EventHandler<LoadEventFired>): EventListener

  @EventName("loadEventFired")
  fun onLoadEventFired(eventListener: suspend (LoadEventFired) -> Unit): EventListener

  @EventName("navigatedWithinDocument")
  @Experimental
  fun onNavigatedWithinDocument(eventListener: EventHandler<NavigatedWithinDocument>): EventListener

  @EventName("navigatedWithinDocument")
  @Experimental
  fun onNavigatedWithinDocument(eventListener: suspend (NavigatedWithinDocument) -> Unit): EventListener

  @EventName("screencastFrame")
  @Experimental
  fun onScreencastFrame(eventListener: EventHandler<ScreencastFrame>): EventListener

  @EventName("screencastFrame")
  @Experimental
  fun onScreencastFrame(eventListener: suspend (ScreencastFrame) -> Unit): EventListener

  @EventName("screencastVisibilityChanged")
  @Experimental
  fun onScreencastVisibilityChanged(eventListener: EventHandler<ScreencastVisibilityChanged>): EventListener

  @EventName("screencastVisibilityChanged")
  @Experimental
  fun onScreencastVisibilityChanged(eventListener: suspend (ScreencastVisibilityChanged) -> Unit): EventListener

  @EventName("windowOpen")
  fun onWindowOpen(eventListener: EventHandler<WindowOpen>): EventListener

  @EventName("windowOpen")
  fun onWindowOpen(eventListener: suspend (WindowOpen) -> Unit): EventListener

  @EventName("compilationCacheProduced")
  @Experimental
  fun onCompilationCacheProduced(eventListener: EventHandler<CompilationCacheProduced>): EventListener

  @EventName("compilationCacheProduced")
  @Experimental
  fun onCompilationCacheProduced(eventListener: suspend (CompilationCacheProduced) -> Unit): EventListener
}
