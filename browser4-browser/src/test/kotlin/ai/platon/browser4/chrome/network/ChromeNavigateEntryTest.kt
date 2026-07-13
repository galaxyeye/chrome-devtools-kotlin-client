package ai.platon.browser4.chrome.network

import ai.platon.browser4.api.model.NavigateEntry
import ai.platon.browser4.chrome.protocol.events.network.RequestWillBeSent
import ai.platon.browser4.chrome.protocol.events.network.ResponseReceived
import ai.platon.browser4.chrome.protocol.events.page.FrameNavigated
import ai.platon.browser4.chrome.protocol.types.network.Initiator
import ai.platon.browser4.chrome.protocol.types.network.InitiatorType
import ai.platon.browser4.chrome.protocol.types.network.Request
import ai.platon.browser4.chrome.protocol.types.network.RequestReferrerPolicy
import ai.platon.browser4.chrome.protocol.types.network.ResourcePriority
import ai.platon.browser4.chrome.protocol.types.network.ResourceType
import ai.platon.browser4.chrome.protocol.types.network.Response
import ai.platon.browser4.chrome.protocol.types.page.CrossOriginIsolatedContextType
import ai.platon.browser4.chrome.protocol.types.page.Frame
import ai.platon.browser4.chrome.protocol.types.page.GatedAPIFeatures
import ai.platon.browser4.chrome.protocol.types.page.NavigationType
import ai.platon.browser4.chrome.protocol.types.page.SecureContextType
import ai.platon.browser4.chrome.protocol.types.security.SecurityState
import kotlinx.serialization.json.JsonObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ChromeNavigateEntryTest {

    private fun createNavigateEntry() = NavigateEntry(url = "https://example.com")

    private fun createDocumentRequest(
        requestId: String = "req-1",
        url: String = "https://example.com"
    ) = RequestWillBeSent(
        requestId = requestId,
        loaderId = "loader-1",
        documentURL = url,
        request = Request(
            url = url, method = "GET", headers = JsonObject(emptyMap()),
            initialPriority = ResourcePriority.MEDIUM,
            referrerPolicy = RequestReferrerPolicy.NO_REFERRER_WHEN_DOWNGRADE
        ),
        timestamp = 1000.0,
        wallTime = 1000.0,
        initiator = Initiator(type = InitiatorType.OTHER),
        redirectHasExtraInfo = false,
        type = ResourceType.DOCUMENT
    )

    private fun createRequest(type: ResourceType? = null) = RequestWillBeSent(
        requestId = "req-1",
        loaderId = "loader-1",
        documentURL = "https://example.com",
        request = Request(
            url = "https://example.com", method = "GET", headers = JsonObject(emptyMap()),
            initialPriority = ResourcePriority.MEDIUM,
            referrerPolicy = RequestReferrerPolicy.NO_REFERRER_WHEN_DOWNGRADE
        ),
        timestamp = 1000.0,
        wallTime = 1000.0,
        initiator = Initiator(type = InitiatorType.OTHER),
        redirectHasExtraInfo = false,
        type = type
    )

    private fun createResponse(type: ResourceType = ResourceType.DOCUMENT) = ResponseReceived(
        requestId = "req-1",
        loaderId = "loader-1",
        timestamp = 1000.0,
        type = type,
        response = Response(
            url = "https://example.com",
            status = 200,
            statusText = "OK",
            headers = JsonObject(emptyMap()),
            mimeType = "text/html",
            charset = "utf-8",
            connectionReused = false,
            connectionId = 1.0,
            encodedDataLength = 1000.0,
            securityState = SecurityState.SECURE
        ),
        hasExtraInfo = false
    )

    private fun createFrame(
        id: String = "main-frame",
        parentId: String? = null,
        url: String = "https://example.com"
    ) = Frame(
        id = id,
        parentId = parentId,
        loaderId = "loader-1",
        url = url,
        domainAndRegistry = "example.com",
        securityOrigin = "https://example.com",
        mimeType = "text/html",
        secureContextType = SecureContextType.SECURE,
        crossOriginIsolatedContextType = CrossOriginIsolatedContextType.NOT_ISOLATED,
        gatedAPIFeatures = emptyList<GatedAPIFeatures>()
    )

    @Test
    @DisplayName("isMinorResource returns true when type is null")
    fun isMinorResourceReturnsTrueWhenTypeIsNull() {
        val entry = ChromeNavigateEntry(createNavigateEntry())
        val event = createRequest(type = null)
        assertTrue(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("isMinorResource returns false when mainFrame not yet received")
    fun isMinorResourceReturnsFalseWhenMainFrameNotReceived() {
        val entry = ChromeNavigateEntry(createNavigateEntry())
        val event = createDocumentRequest()
        // mainFrameReceived is false because mainFrameId is null
        assertFalse(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("isMinorResource returns false for DOCUMENT type after main frame received")
    fun isMinorResourceReturnsFalseForDocumentType() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "main-frame"
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = createRequest(type = ResourceType.DOCUMENT)
        assertFalse(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("isMinorResource returns true for FONT type after main frame received")
    fun isMinorResourceReturnsTrueForFontType() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "main-frame"
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = createRequest(type = ResourceType.FONT)
        assertTrue(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("isMinorResource returns true for IMAGE type after main frame received")
    fun isMinorResourceReturnsTrueForImageType() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "main-frame"
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = createRequest(type = ResourceType.IMAGE)
        assertTrue(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("isMinorResource returns true for MEDIA type after main frame received")
    fun isMinorResourceReturnsTrueForMediaType() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "main-frame"
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = createRequest(type = ResourceType.MEDIA)
        assertTrue(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("isMinorResource returns false for SCRIPT type after main frame received")
    fun isMinorResourceReturnsFalseForScriptType() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "main-frame"
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = createRequest(type = ResourceType.SCRIPT)
        assertFalse(entry.isMinorResource(event))
    }

    @Test
    @DisplayName("updateStateAfterFrameNavigated sets mainFrameId for top-level frame")
    fun updateStateAfterFrameNavigatedSetsMainFrameIdForTopFrame() {
        val navigateEntry = createNavigateEntry()
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = FrameNavigated(frame = createFrame(), type = NavigationType.NAVIGATION)
        entry.updateStateAfterFrameNavigated(event)
        assertEquals("main-frame", navigateEntry.mainFrameId)
    }

    @Test
    @DisplayName("updateStateAfterFrameNavigated does not set mainFrameId for child frame")
    fun updateStateAfterFrameNavigatedSkipsChildFrame() {
        val navigateEntry = createNavigateEntry()
        val entry = ChromeNavigateEntry(navigateEntry)
        val event = FrameNavigated(
            frame = createFrame(id = "child-frame", parentId = "parent-frame", url = "about:blank"),
            type = NavigationType.NAVIGATION
        )
        entry.updateStateAfterFrameNavigated(event)
        assertNull(navigateEntry.mainFrameId)
    }

    @Test
    @DisplayName("updateStateBeforeRequestSent sets main request id for first DOCUMENT")
    fun updateStateBeforeRequestSentSetsMainRequestForFirstDocument() {
        val navigateEntry = createNavigateEntry()
        val entry = ChromeNavigateEntry(navigateEntry)
        assertEquals("", navigateEntry.mainRequestId)

        val event = createDocumentRequest(requestId = "main-req-id")
        entry.updateStateBeforeRequestSent(event)

        assertEquals(1, navigateEntry.networkRequestCount.get())
        assertEquals("main-req-id", navigateEntry.mainRequestId)
    }

    @Test
    @DisplayName("updateStateBeforeRequestSent ignores non-DOCUMENT request before main frame")
    fun updateStateBeforeRequestSentIgnoresNonDocumentBeforeMainFrame() {
        val navigateEntry = createNavigateEntry()
        val entry = ChromeNavigateEntry(navigateEntry)

        val event = createRequest(type = ResourceType.SCRIPT)
        entry.updateStateBeforeRequestSent(event)

        assertEquals(1, navigateEntry.networkRequestCount.get())
        assertFalse(navigateEntry.mainFrameReceived)
    }

    @Test
    @DisplayName("updateStateAfterResponseReceived sets main response for first DOCUMENT")
    fun updateStateAfterResponseReceivedSetsMainResponseForFirstDocument() {
        val navigateEntry = createNavigateEntry()
        val entry = ChromeNavigateEntry(navigateEntry)
        assertEquals(-1, navigateEntry.mainResponseStatus)

        val event = createResponse(type = ResourceType.DOCUMENT)
        entry.updateStateAfterResponseReceived(event)

        assertEquals(1, navigateEntry.networkResponseCount.get())
        assertEquals(200, navigateEntry.mainResponseStatus)
        assertEquals("OK", navigateEntry.mainResponseStatusText)
    }

    @Test
    @DisplayName("updateStateAfterResponseReceived ignores non-DOCUMENT response before main frame")
    fun updateStateAfterResponseReceivedIgnoresNonDocumentBeforeMainFrame() {
        val navigateEntry = createNavigateEntry()
        val entry = ChromeNavigateEntry(navigateEntry)

        val event = createResponse(type = ResourceType.SCRIPT)
        entry.updateStateAfterResponseReceived(event)

        assertEquals(1, navigateEntry.networkResponseCount.get())
        assertFalse(navigateEntry.mainFrameReceived)
    }

    @Test
    @DisplayName("updateStateBeforeRequestSent skips main request when frame already received")
    fun updateStateBeforeRequestSentSkipsAfterMainFrameReceived() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "existing-frame"
        val entry = ChromeNavigateEntry(navigateEntry)

        val event = createDocumentRequest(requestId = "second-req")
        entry.updateStateBeforeRequestSent(event)

        assertEquals(1, navigateEntry.networkRequestCount.get())
    }

    @Test
    @DisplayName("updateStateAfterResponseReceived skips main response when frame already received")
    fun updateStateAfterResponseReceivedSkipsAfterMainFrameReceived() {
        val navigateEntry = createNavigateEntry()
        navigateEntry.mainFrameId = "existing-frame"
        val entry = ChromeNavigateEntry(navigateEntry)

        val event = createResponse(type = ResourceType.DOCUMENT)
        entry.updateStateAfterResponseReceived(event)

        assertEquals(1, navigateEntry.networkResponseCount.get())
    }
}
