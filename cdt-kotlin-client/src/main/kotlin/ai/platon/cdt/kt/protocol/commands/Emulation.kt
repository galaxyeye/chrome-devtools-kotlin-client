@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.emulation.ScreenOrientationLockChanged
import ai.platon.cdt.kt.protocol.events.emulation.VirtualTimeBudgetExpired
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import ai.platon.cdt.kt.protocol.types.emulation.DevicePosture
import ai.platon.cdt.kt.protocol.types.emulation.DisabledImageType
import ai.platon.cdt.kt.protocol.types.emulation.DisplayFeature
import ai.platon.cdt.kt.protocol.types.emulation.MediaFeature
import ai.platon.cdt.kt.protocol.types.emulation.PressureMetadata
import ai.platon.cdt.kt.protocol.types.emulation.PressureSource
import ai.platon.cdt.kt.protocol.types.emulation.PressureState
import ai.platon.cdt.kt.protocol.types.emulation.SafeAreaInsets
import ai.platon.cdt.kt.protocol.types.emulation.ScreenInfo
import ai.platon.cdt.kt.protocol.types.emulation.ScreenOrientation
import ai.platon.cdt.kt.protocol.types.emulation.SensorMetadata
import ai.platon.cdt.kt.protocol.types.emulation.SensorReading
import ai.platon.cdt.kt.protocol.types.emulation.SensorType
import ai.platon.cdt.kt.protocol.types.emulation.SetDeviceMetricsOverrideScrollbarType
import ai.platon.cdt.kt.protocol.types.emulation.SetEmitTouchEventsForMouseConfiguration
import ai.platon.cdt.kt.protocol.types.emulation.SetEmulatedVisionDeficiencyType
import ai.platon.cdt.kt.protocol.types.emulation.UserAgentMetadata
import ai.platon.cdt.kt.protocol.types.emulation.VirtualTimePolicy
import ai.platon.cdt.kt.protocol.types.emulation.WorkAreaInsets
import ai.platon.cdt.kt.protocol.types.page.Viewport
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * This domain emulates different environments for the page.
 */
interface Emulation {
  /**
   * Tells whether emulation is supported.
   */
  @Deprecated("Deprecated by protocol")
  @Returns("result")
  suspend fun canEmulate(): Boolean

  /**
   * Clears the overridden device metrics.
   */
  suspend fun clearDeviceMetricsOverride()

  /**
   * Clears the overridden Geolocation Position and Error.
   */
  suspend fun clearGeolocationOverride()

  /**
   * Requests that page scale factor is reset to initial values.
   */
  @Experimental
  suspend fun resetPageScaleFactor()

  /**
   * Enables or disables simulating a focused and active page.
   * @param enabled Whether to enable to disable focus emulation.
   */
  @Experimental
  suspend fun setFocusEmulationEnabled(@ParamName("enabled") enabled: Boolean)

  /**
   * Automatically render all web contents using a dark theme.
   * @param enabled Whether to enable or disable automatic dark mode.
   * If not specified, any existing override will be cleared.
   */
  @Experimental
  suspend fun setAutoDarkModeOverride(@ParamName("enabled") @Optional enabled: Boolean? = null)

  @Experimental
  suspend fun setAutoDarkModeOverride() {
    return setAutoDarkModeOverride(null)
  }

  /**
   * Enables CPU throttling to emulate slow CPUs.
   * @param rate Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
   */
  suspend fun setCPUThrottlingRate(@ParamName("rate") rate: Double)

  /**
   * Sets or clears an override of the default background color of the frame. This override is used
   * if the content does not specify one.
   * @param color RGBA of the default background color. If not specified, any existing override will be
   * cleared.
   */
  suspend fun setDefaultBackgroundColorOverride(@ParamName("color") @Optional color: RGBA? = null)

  suspend fun setDefaultBackgroundColorOverride() {
    return setDefaultBackgroundColorOverride(null)
  }

  /**
   * Overrides the values for env(safe-area-inset-*) and env(safe-area-max-inset-*). Unset values will cause the
   * respective variables to be undefined, even if previously overridden.
   * @param insets
   */
  @Experimental
  suspend fun setSafeAreaInsetsOverride(@ParamName("insets") insets: SafeAreaInsets)

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height,
   * window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media
   * query results).
   * @param width Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
   * @param height Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
   * @param deviceScaleFactor Overriding device scale factor value. 0 disables the override.
   * @param mobile Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text
   * autosizing and more.
   * @param scale Scale to apply to resulting view image.
   * @param screenWidth Overriding screen width value in pixels (minimum 0, maximum 10000000).
   * @param screenHeight Overriding screen height value in pixels (minimum 0, maximum 10000000).
   * @param positionX Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
   * @param positionY Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
   * @param dontSetVisibleSize Do not set visible view size, rely upon explicit setVisibleSize call.
   * @param screenOrientation Screen orientation override.
   * @param viewport If set, the visible area of the page will be overridden to this viewport. This viewport
   * change is not observed by the page, e.g. viewport-relative elements do not change positions.
   * @param displayFeature If set, the display feature of a multi-segment screen. If not set, multi-segment support
   * is turned-off.
   * Deprecated, use Emulation.setDisplayFeaturesOverride.
   * @param devicePosture If set, the posture of a foldable device. If not set the posture is set
   * to continuous.
   * Deprecated, use Emulation.setDevicePostureOverride.
   * @param scrollbarType Scrollbar type. Default: `default`.
   * @param screenOrientationLockEmulation If set to true, enables screen orientation lock emulation, which
   * intercepts screen.orientation.lock() calls from the page and reports
   * orientation changes via screenOrientationLockChanged events. This is
   * useful for emulating mobile device orientation lock behavior in
   * responsive design mode.
   */
  suspend fun setDeviceMetricsOverride(
    @ParamName("width") width: Int,
    @ParamName("height") height: Int,
    @ParamName("deviceScaleFactor") deviceScaleFactor: Double,
    @ParamName("mobile") mobile: Boolean,
    @ParamName("scale") @Optional @Experimental scale: Double? = null,
    @ParamName("screenWidth") @Optional @Experimental screenWidth: Int? = null,
    @ParamName("screenHeight") @Optional @Experimental screenHeight: Int? = null,
    @ParamName("positionX") @Optional @Experimental positionX: Int? = null,
    @ParamName("positionY") @Optional @Experimental positionY: Int? = null,
    @ParamName("dontSetVisibleSize") @Optional @Experimental dontSetVisibleSize: Boolean? = null,
    @ParamName("screenOrientation") @Optional screenOrientation: ScreenOrientation? = null,
    @ParamName("viewport") @Optional @Experimental viewport: Viewport? = null,
    @ParamName("displayFeature") @Optional @Experimental displayFeature: DisplayFeature? = null,
    @ParamName("devicePosture") @Optional @Experimental devicePosture: DevicePosture? = null,
    @ParamName("scrollbarType") @Optional @Experimental scrollbarType: SetDeviceMetricsOverrideScrollbarType? = null,
    @ParamName("screenOrientationLockEmulation") @Optional @Experimental screenOrientationLockEmulation: Boolean? = null,
  )

  suspend fun setDeviceMetricsOverride(
    @ParamName("width") width: Int,
    @ParamName("height") height: Int,
    @ParamName("deviceScaleFactor") deviceScaleFactor: Double,
    @ParamName("mobile") mobile: Boolean,
  ) {
    return setDeviceMetricsOverride(width, height, deviceScaleFactor, mobile, null, null, null, null, null, null, null, null, null, null, null, null)
  }

  /**
   * Start reporting the given posture value to the Device Posture API.
   * This override can also be set in setDeviceMetricsOverride().
   * @param posture
   */
  @Experimental
  suspend fun setDevicePostureOverride(@ParamName("posture") posture: DevicePosture)

  /**
   * Clears a device posture override set with either setDeviceMetricsOverride()
   * or setDevicePostureOverride() and starts using posture information from the
   * platform again.
   * Does nothing if no override is set.
   */
  @Experimental
  suspend fun clearDevicePostureOverride()

  /**
   * Start using the given display features to pupulate the Viewport Segments API.
   * This override can also be set in setDeviceMetricsOverride().
   * @param features
   */
  @Experimental
  suspend fun setDisplayFeaturesOverride(@ParamName("features") features: List<DisplayFeature>)

  /**
   * Clears the display features override set with either setDeviceMetricsOverride()
   * or setDisplayFeaturesOverride() and starts using display features from the
   * platform again.
   * Does nothing if no override is set.
   */
  @Experimental
  suspend fun clearDisplayFeaturesOverride()

  /**
   * @param hidden Whether scrollbars should be always hidden.
   */
  @Experimental
  suspend fun setScrollbarsHidden(@ParamName("hidden") hidden: Boolean)

  /**
   * @param disabled Whether document.coookie API should be disabled.
   */
  @Experimental
  suspend fun setDocumentCookieDisabled(@ParamName("disabled") disabled: Boolean)

  /**
   * @param enabled Whether touch emulation based on mouse input should be enabled.
   * @param configuration Touch/gesture events configuration. Default: current platform.
   */
  @Experimental
  suspend fun setEmitTouchEventsForMouse(@ParamName("enabled") enabled: Boolean, @ParamName("configuration") @Optional configuration: SetEmitTouchEventsForMouseConfiguration? = null)

  @Experimental
  suspend fun setEmitTouchEventsForMouse(@ParamName("enabled") enabled: Boolean) {
    return setEmitTouchEventsForMouse(enabled, null)
  }

  /**
   * Emulates the given media type or media feature for CSS media queries.
   * @param media Media type to emulate. Empty string disables the override.
   * @param features Media features to emulate.
   */
  suspend fun setEmulatedMedia(@ParamName("media") @Optional media: String? = null, @ParamName("features") @Optional features: List<MediaFeature>? = null)

  suspend fun setEmulatedMedia() {
    return setEmulatedMedia(null, null)
  }

  /**
   * Emulates the given vision deficiency.
   * @param type Vision deficiency to emulate. Order: best-effort emulations come first, followed by any
   * physiologically accurate emulations for medically recognized color vision deficiencies.
   */
  suspend fun setEmulatedVisionDeficiency(@ParamName("type") type: SetEmulatedVisionDeficiencyType)

  /**
   * Emulates the given OS text scale.
   * @param scale
   */
  suspend fun setEmulatedOSTextScale(@ParamName("scale") @Optional scale: Double? = null)

  suspend fun setEmulatedOSTextScale() {
    return setEmulatedOSTextScale(null)
  }

  /**
   * Overrides the Geolocation Position or Error. Omitting latitude, longitude or
   * accuracy emulates position unavailable.
   * @param latitude Mock latitude
   * @param longitude Mock longitude
   * @param accuracy Mock accuracy
   * @param altitude Mock altitude
   * @param altitudeAccuracy Mock altitudeAccuracy
   * @param heading Mock heading
   * @param speed Mock speed
   */
  suspend fun setGeolocationOverride(
    @ParamName("latitude") @Optional latitude: Double? = null,
    @ParamName("longitude") @Optional longitude: Double? = null,
    @ParamName("accuracy") @Optional accuracy: Double? = null,
    @ParamName("altitude") @Optional altitude: Double? = null,
    @ParamName("altitudeAccuracy") @Optional altitudeAccuracy: Double? = null,
    @ParamName("heading") @Optional heading: Double? = null,
    @ParamName("speed") @Optional speed: Double? = null,
  )

  suspend fun setGeolocationOverride() {
    return setGeolocationOverride(null, null, null, null, null, null, null)
  }

  /**
   * @param type
   */
  @Experimental
  @Returns("requestedSamplingFrequency")
  suspend fun getOverriddenSensorInformation(@ParamName("type") type: SensorType): Double

  /**
   * Overrides a platform sensor of a given type. If |enabled| is true, calls to
   * Sensor.start() will use a virtual sensor as backend rather than fetching
   * data from a real hardware sensor. Otherwise, existing virtual
   * sensor-backend Sensor objects will fire an error event and new calls to
   * Sensor.start() will attempt to use a real sensor instead.
   * @param enabled
   * @param type
   * @param metadata
   */
  @Experimental
  suspend fun setSensorOverrideEnabled(
    @ParamName("enabled") enabled: Boolean,
    @ParamName("type") type: SensorType,
    @ParamName("metadata") @Optional metadata: SensorMetadata? = null,
  )

  @Experimental
  suspend fun setSensorOverrideEnabled(@ParamName("enabled") enabled: Boolean, @ParamName("type") type: SensorType) {
    return setSensorOverrideEnabled(enabled, type, null)
  }

  /**
   * Updates the sensor readings reported by a sensor type previously overridden
   * by setSensorOverrideEnabled.
   * @param type
   * @param reading
   */
  @Experimental
  suspend fun setSensorOverrideReadings(@ParamName("type") type: SensorType, @ParamName("reading") reading: SensorReading)

  /**
   * Overrides a pressure source of a given type, as used by the Compute
   * Pressure API, so that updates to PressureObserver.observe() are provided
   * via setPressureStateOverride instead of being retrieved from
   * platform-provided telemetry data.
   * @param enabled
   * @param source
   * @param metadata
   */
  @Experimental
  suspend fun setPressureSourceOverrideEnabled(
    @ParamName("enabled") enabled: Boolean,
    @ParamName("source") source: PressureSource,
    @ParamName("metadata") @Optional metadata: PressureMetadata? = null,
  )

  @Experimental
  suspend fun setPressureSourceOverrideEnabled(@ParamName("enabled") enabled: Boolean, @ParamName("source") source: PressureSource) {
    return setPressureSourceOverrideEnabled(enabled, source, null)
  }

  /**
   * Provides a given pressure state that will be processed and eventually be
   * delivered to PressureObserver users. |source| must have been previously
   * overridden by setPressureSourceOverrideEnabled.
   * @param source
   * @param state
   */
  @Experimental
  suspend fun setPressureStateOverride(@ParamName("source") source: PressureSource, @ParamName("state") state: PressureState)

  /**
   * Overrides the Idle state.
   * @param isUserActive Mock isUserActive
   * @param isScreenUnlocked Mock isScreenUnlocked
   */
  suspend fun setIdleOverride(@ParamName("isUserActive") isUserActive: Boolean, @ParamName("isScreenUnlocked") isScreenUnlocked: Boolean)

  /**
   * Clears Idle state overrides.
   */
  suspend fun clearIdleOverride()

  /**
   * Overrides value returned by the javascript navigator object.
   * @param platform The platform navigator.platform should return.
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun setNavigatorOverrides(@ParamName("platform") platform: String)

  /**
   * Sets a specified page scale factor.
   * @param pageScaleFactor Page scale factor.
   */
  @Experimental
  suspend fun setPageScaleFactor(@ParamName("pageScaleFactor") pageScaleFactor: Double)

  /**
   * Switches script execution in the page.
   * @param value Whether script execution should be disabled in the page.
   */
  suspend fun setScriptExecutionDisabled(@ParamName("value") `value`: Boolean)

  /**
   * Enables touch on platforms which do not support them.
   * @param enabled Whether the touch event emulation should be enabled.
   * @param maxTouchPoints Maximum touch points supported. Defaults to one.
   */
  suspend fun setTouchEmulationEnabled(@ParamName("enabled") enabled: Boolean, @ParamName("maxTouchPoints") @Optional maxTouchPoints: Int? = null)

  suspend fun setTouchEmulationEnabled(@ParamName("enabled") enabled: Boolean) {
    return setTouchEmulationEnabled(enabled, null)
  }

  /**
   * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and sets
   * the current virtual time policy.  Note this supersedes any previous time budget.
   * @param policy
   * @param budget If set, after this many virtual milliseconds have elapsed virtual time will be paused and a
   * virtualTimeBudgetExpired event is sent.
   * @param maxVirtualTimeTaskStarvationCount If set this specifies the maximum number of tasks that can be run before virtual is forced
   * forwards to prevent deadlock.
   * @param initialVirtualTime If set, base::Time::Now will be overridden to initially return this value.
   */
  @Experimental
  @Returns("virtualTimeTicksBase")
  suspend fun setVirtualTimePolicy(
    @ParamName("policy") policy: VirtualTimePolicy,
    @ParamName("budget") @Optional budget: Double? = null,
    @ParamName("maxVirtualTimeTaskStarvationCount") @Optional maxVirtualTimeTaskStarvationCount: Int? = null,
    @ParamName("initialVirtualTime") @Optional initialVirtualTime: Double? = null,
  ): Double

  @Experimental
  @Returns("virtualTimeTicksBase")
  suspend fun setVirtualTimePolicy(@ParamName("policy") policy: VirtualTimePolicy): Double {
    return setVirtualTimePolicy(policy, null, null, null)
  }

  /**
   * Overrides default host system locale with the specified one.
   * @param locale ICU style C locale (e.g. "en_US"). If not specified or empty, disables the override and
   * restores default host system locale.
   */
  @Experimental
  suspend fun setLocaleOverride(@ParamName("locale") @Optional locale: String? = null)

  @Experimental
  suspend fun setLocaleOverride() {
    return setLocaleOverride(null)
  }

  /**
   * Overrides default host system timezone with the specified one.
   * @param timezoneId The timezone identifier. List of supported timezones:
   * https://source.chromium.org/chromium/chromium/deps/icu.git/+/faee8bc70570192d82d2978a71e2a615788597d1:source/data/misc/metaZones.txt
   * If empty, disables the override and restores default host system timezone.
   */
  suspend fun setTimezoneOverride(@ParamName("timezoneId") timezoneId: String)

  /**
   * Resizes the frame/viewport of the page. Note that this does not affect the frame's container
   * (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported
   * on Android.
   * @param width Frame width (DIP).
   * @param height Frame height (DIP).
   */
  @Deprecated("Deprecated by protocol")
  @Experimental
  suspend fun setVisibleSize(@ParamName("width") width: Int, @ParamName("height") height: Int)

  /**
   * @param imageTypes Image types to disable.
   */
  @Experimental
  suspend fun setDisabledImageTypes(@ParamName("imageTypes") imageTypes: List<DisabledImageType>)

  /**
   * Override the value of navigator.connection.saveData
   * @param dataSaverEnabled Override value. Omitting the parameter disables the override.
   */
  @Experimental
  suspend fun setDataSaverOverride(@ParamName("dataSaverEnabled") @Optional dataSaverEnabled: Boolean? = null)

  @Experimental
  suspend fun setDataSaverOverride() {
    return setDataSaverOverride(null)
  }

  /**
   * @param hardwareConcurrency Hardware concurrency to report
   */
  @Experimental
  suspend fun setHardwareConcurrencyOverride(@ParamName("hardwareConcurrency") hardwareConcurrency: Int)

  /**
   * Allows overriding user agent with the given string.
   * `userAgentMetadata` must be set for Client Hint headers to be sent.
   * @param userAgent User agent to use.
   * @param acceptLanguage Browser language to emulate.
   * @param platform The platform navigator.platform should return.
   * @param userAgentMetadata To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData
   */
  suspend fun setUserAgentOverride(
    @ParamName("userAgent") userAgent: String,
    @ParamName("acceptLanguage") @Optional acceptLanguage: String? = null,
    @ParamName("platform") @Optional platform: String? = null,
    @ParamName("userAgentMetadata") @Optional @Experimental userAgentMetadata: UserAgentMetadata? = null,
  )

  suspend fun setUserAgentOverride(@ParamName("userAgent") userAgent: String) {
    return setUserAgentOverride(userAgent, null, null, null)
  }

  /**
   * Allows overriding the automation flag.
   * @param enabled Whether the override should be enabled.
   */
  @Experimental
  suspend fun setAutomationOverride(@ParamName("enabled") enabled: Boolean)

  /**
   * Allows overriding the difference between the small and large viewport sizes, which determine the
   * value of the `svh` and `lvh` unit, respectively. Only supported for top-level frames.
   * @param difference This will cause an element of size 100svh to be `difference` pixels smaller than an element
   * of size 100lvh.
   */
  @Experimental
  suspend fun setSmallViewportHeightDifferenceOverride(@ParamName("difference") difference: Int)

  /**
   * Returns device's screen configuration. In headful mode, the physical screens configuration is returned,
   * whereas in headless mode, a virtual headless screen configuration is provided instead.
   */
  @Experimental
  @Returns("screenInfos")
  @ReturnTypeParameter(ScreenInfo::class)
  suspend fun getScreenInfos(): List<ScreenInfo>

  /**
   * Add a new screen to the device. Only supported in headless mode.
   * @param left Offset of the left edge of the screen in pixels.
   * @param top Offset of the top edge of the screen in pixels.
   * @param width The width of the screen in pixels.
   * @param height The height of the screen in pixels.
   * @param workAreaInsets Specifies the screen's work area. Default is entire screen.
   * @param devicePixelRatio Specifies the screen's device pixel ratio. Default is 1.
   * @param rotation Specifies the screen's rotation angle. Available values are 0, 90, 180 and 270. Default is 0.
   * @param colorDepth Specifies the screen's color depth in bits. Default is 24.
   * @param label Specifies the descriptive label for the screen. Default is none.
   * @param isInternal Indicates whether the screen is internal to the device or external, attached to the device. Default is false.
   */
  @Experimental
  @Returns("screenInfo")
  suspend fun addScreen(
    @ParamName("left") left: Int,
    @ParamName("top") top: Int,
    @ParamName("width") width: Int,
    @ParamName("height") height: Int,
    @ParamName("workAreaInsets") @Optional workAreaInsets: WorkAreaInsets? = null,
    @ParamName("devicePixelRatio") @Optional devicePixelRatio: Double? = null,
    @ParamName("rotation") @Optional rotation: Int? = null,
    @ParamName("colorDepth") @Optional colorDepth: Int? = null,
    @ParamName("label") @Optional label: String? = null,
    @ParamName("isInternal") @Optional isInternal: Boolean? = null,
  ): ScreenInfo

  @Experimental
  @Returns("screenInfo")
  suspend fun addScreen(
    @ParamName("left") left: Int,
    @ParamName("top") top: Int,
    @ParamName("width") width: Int,
    @ParamName("height") height: Int,
  ): ScreenInfo {
    return addScreen(left, top, width, height, null, null, null, null, null, null)
  }

  /**
   * Updates specified screen parameters. Only supported in headless mode.
   * @param screenId Target screen identifier.
   * @param left Offset of the left edge of the screen in pixels.
   * @param top Offset of the top edge of the screen in pixels.
   * @param width The width of the screen in pixels.
   * @param height The height of the screen in pixels.
   * @param workAreaInsets Specifies the screen's work area.
   * @param devicePixelRatio Specifies the screen's device pixel ratio.
   * @param rotation Specifies the screen's rotation angle. Available values are 0, 90, 180 and 270.
   * @param colorDepth Specifies the screen's color depth in bits.
   * @param label Specifies the descriptive label for the screen.
   * @param isInternal Indicates whether the screen is internal to the device or external, attached to the device. Default is false.
   */
  @Experimental
  @Returns("screenInfo")
  suspend fun updateScreen(
    @ParamName("screenId") screenId: String,
    @ParamName("left") @Optional left: Int? = null,
    @ParamName("top") @Optional top: Int? = null,
    @ParamName("width") @Optional width: Int? = null,
    @ParamName("height") @Optional height: Int? = null,
    @ParamName("workAreaInsets") @Optional workAreaInsets: WorkAreaInsets? = null,
    @ParamName("devicePixelRatio") @Optional devicePixelRatio: Double? = null,
    @ParamName("rotation") @Optional rotation: Int? = null,
    @ParamName("colorDepth") @Optional colorDepth: Int? = null,
    @ParamName("label") @Optional label: String? = null,
    @ParamName("isInternal") @Optional isInternal: Boolean? = null,
  ): ScreenInfo

  @Experimental
  @Returns("screenInfo")
  suspend fun updateScreen(@ParamName("screenId") screenId: String): ScreenInfo {
    return updateScreen(screenId, null, null, null, null, null, null, null, null, null, null)
  }

  /**
   * Remove screen from the device. Only supported in headless mode.
   * @param screenId
   */
  @Experimental
  suspend fun removeScreen(@ParamName("screenId") screenId: String)

  /**
   * Set primary screen. Only supported in headless mode.
   * Note that this changes the coordinate system origin to the top-left
   * of the new primary screen, updating the bounds and work areas
   * of all existing screens accordingly.
   * @param screenId
   */
  @Experimental
  suspend fun setPrimaryScreen(@ParamName("screenId") screenId: String)

  @EventName("virtualTimeBudgetExpired")
  @Experimental
  fun onVirtualTimeBudgetExpired(eventListener: EventHandler<VirtualTimeBudgetExpired>): EventListener

  @EventName("virtualTimeBudgetExpired")
  @Experimental
  fun onVirtualTimeBudgetExpired(eventListener: suspend (VirtualTimeBudgetExpired) -> Unit): EventListener

  @EventName("screenOrientationLockChanged")
  @Experimental
  fun onScreenOrientationLockChanged(eventListener: EventHandler<ScreenOrientationLockChanged>): EventListener

  @EventName("screenOrientationLockChanged")
  @Experimental
  fun onScreenOrientationLockChanged(eventListener: suspend (ScreenOrientationLockChanged) -> Unit): EventListener
}
