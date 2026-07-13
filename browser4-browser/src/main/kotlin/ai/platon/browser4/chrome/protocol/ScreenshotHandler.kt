package ai.platon.browser4.chrome.protocol

import ai.platon.browser4.chrome.protocol.types.page.CaptureScreenshotFormat
import ai.platon.browser4.chrome.protocol.types.page.Viewport
import ai.platon.browser4.api.model.BrowserSettings
import ai.platon.browser4.api.BrowserProtocol
import ai.platon.browser4.api.model.NodeRef
import ai.platon.pulsar.common.AppContext
import ai.platon.pulsar.common.getLogger
import ai.platon.pulsar.common.math.geometric.RectD
import kotlin.math.roundToInt

class ScreenshotHandler(
    private val page: PageHandler,
    private val bp: BrowserProtocol,
) {
    private val logger = getLogger(this)
    private val isActive get() = AppContext.isActive && (bp as DirectChromeProtocol).isOpen
    private fun activeCdp() = bp.takeIf { isActive }
    private val debugLevel = System.getProperty("browser.additionalDebugLevel")?.toIntOrNull() ?: 0

    /**
     * Capture page screenshot.
     * */
    suspend fun screenshot(fullPage: Boolean): String? {
        if (!fullPage) {
            return activeCdp()?.captureScreenshot()
        }

        val metrics = activeCdp()?.getLayoutMetrics() ?: return null
        val rect = metrics.contentSize
        val width = rect.width.toInt()
        val height = rect.height.toInt()

        bp.setDeviceMetricsOverride(
            mobile = false,
            width = width,
            height = height,
            deviceScaleFactor = 1.0,
            screenWidth = width,
            screenHeight = height,
        )

        // PNG = Crisp, precise, lossless, and supports transparency (ideal for testing and UI design)
        // JPEG = Compact, softly detailed, lossy, and opaque (suitable for presentation and archiving)
        val format = CaptureScreenshotFormat.JPEG
        val result = bp.captureScreenshot(
            format = format,
            captureBeyondViewport = true,
        )

        bp.clearDeviceMetricsOverride()

        return result
    }

    suspend fun screenshot(selector: String): String? {
        val node = page.dom.queryLocator(selector)
        if (node == null) {
            logger.info("No such element <{}>", selector)
            return null
        }

        return captureScreenshotWithoutVi(node, selector)
    }

    suspend fun screenshot(clip: RectD) = captureScreenshot0(null, clip)

    suspend fun screenshot(viewport: Viewport) = captureScreenshot0(null, viewport)

    private suspend fun captureScreenshotWithoutVi(node: NodeRef, selector: String): String? {
        val nodeClip = calculateNodeClip(node, selector)
        if (nodeClip == null) {
            logger.info("Can not calculate node clip | {}", selector)
            return null
        }

        val rect = nodeClip.rect
        if (rect == null) {
            logger.info("Can not take clip | {}", selector)
            return null
        }

        return captureScreenshot0(node, rect)
    }

    private suspend fun captureScreenshot0(node: NodeRef?, clip: RectD): String? {
        val viewport = Viewport(
            x = clip.x, y = clip.y,
            width = clip.width, height = clip.height,
            scale = 1.0
        )

        return captureScreenshot0(node, viewport)
    }

    private suspend fun captureScreenshot0(node: NodeRef?, viewport: Viewport): String? {
        // PNG = Crisp, precise, lossless, and supports transparency (ideal for testing and UI design)
        // JPEG = Compact, softly detailed, lossy, and opaque (suitable for presentation and archiving)
        val format = CaptureScreenshotFormat.JPEG

        // Compression quality from range [0..100] (jpeg only).
        val quality = BrowserSettings.SCREENSHOT_QUALITY

        // The viewport has to be visible before screenshot
        if (node != null) {
            // Exactly one of nodeId, backendNodeId, objectId must be provided; use nodeId for stability
            activeCdp()?.scrollIntoViewIfNeeded(node.nodeId)

            val visible = ClickableDOM.create(activeCdp(), node)?.isVisible() ?: false
            if (!visible) {
                return null
            }
        }

        return bp.captureScreenshot(
            format = format,
            quality = quality,
            clip = viewport,
            fromSurface = true,
            captureBeyondViewport = false,
        )
    }

    private suspend fun calculateNodeClip(node: NodeRef, selector: String): NodeClip? {
        // must scroll to top to calculate the client rect
        page.js.evaluate("window.scrollTo(0, 0)")

        val rect = calculateNodeClip0(node, selector)

        val cdpActive = activeCdp() ?: return null

        val viewport = cdpActive.getLayoutMetrics().cssLayoutViewport
        val pageX = viewport.pageX
        val pageY = viewport.pageY

        return NodeClip(node, pageX, pageY, rect)
    }

    private suspend fun calculateNodeClip0(node: NodeRef, selector: String): RectD? {
        val clickableDOM = ClickableDOM.create(activeCdp(), node) ?: return null
        return clickableDOM.boundingBox()
    }
}
