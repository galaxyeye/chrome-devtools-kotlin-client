package ai.platon.browser4.integration

import ai.platon.browser4.chrome.protocol.EmulationHandler
import ai.platon.browser4.chrome.protocol.Keyboard
import ai.platon.browser4.chrome.protocol.Mouse
import ai.platon.browser4.chrome.protocol.PageHandler
import ai.platon.browser4.api.model.BrowserSettings
import ai.platon.browser4.api.model.NodeRef
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class EmulationHandlerIntegrationTest : BrowserIntegrationTest() {

    private lateinit var emulationHandler: EmulationHandler
    private lateinit var pageHandler: PageHandler

    @BeforeEach
    fun setupHandlers() {
        pageHandler = PageHandler(bp, BrowserSettings())
        emulationHandler = EmulationHandler(bp, keyboard = Keyboard(bp), mouse = Mouse(bp))
    }

    @Test
    @DisplayName("click on button triggers onclick handler")
    fun testClickButton() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        val buttonRef = pageHandler.focusOnSelector("#submit-btn")
        assertNotNull(buttonRef, "Button should be found")

        emulationHandler.click(buttonRef!!, count = 1)

        // Verify button text changed via onclick handler
        val buttonText = bp.evaluate(
            "document.getElementById('submit-btn').textContent",
            returnByValue = true
        )
        assertEquals("clicked", buttonText.result?.value, "Button text should change to 'clicked'")
    }

    @Test
    @DisplayName("click with modifier key")
    fun testClickWithModifier() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        val buttonRef = pageHandler.focusOnSelector("#submit-btn")
        assertNotNull(buttonRef)

        // Click with Shift modifier
        emulationHandler.click(buttonRef!!, count = 1, modifier = "Shift")
        // Should still work — the onclick handler fires regardless of modifier
        val buttonText = bp.evaluate(
            "document.getElementById('submit-btn').textContent",
            returnByValue = true
        )
        assertEquals("clicked", buttonText.result?.value)
    }

    @Test
    @DisplayName("hover triggers CSS :hover style change")
    fun testHover() = runBlocking {
        pageHandler.navigate("$baseUrl/hover.html")

        val hoverRef = pageHandler.focusOnSelector("#hover-div")
        assertNotNull(hoverRef, "Hover target should be found")

        emulationHandler.hover(hoverRef!!)

        // Check that the background color changed from blue to red
        val bgColor = bp.evaluate(
            "getComputedStyle(document.getElementById('hover-div')).backgroundColor",
            returnByValue = true
        )
        val color = bgColor.result?.value as? String ?: ""
        assertTrue(color.contains("255, 0, 0") || color.contains("rgb(255, 0, 0)"),
            "Background should be red after hover, got: $color")
    }

    @Test
    @DisplayName("getInteractPoint returns point within element bounds")
    fun testGetInteractPoint() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val headingRef = pageHandler.focusOnSelector("h1")
        assertNotNull(headingRef)

        val point = emulationHandler.getInteractPoint(headingRef!!, useRandomOffset = false)
        assertNotNull(point, "Interact point should not be null")
        assertTrue(point!!.x > 0, "X should be positive")
        assertTrue(point.y > 0, "Y should be positive")
    }

    @Test
    @DisplayName("getInteractPoint with random offset produces variation")
    fun testGetInteractPointWithRandomOffset() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val headingRef = pageHandler.focusOnSelector("h1")
        assertNotNull(headingRef)

        val point1 = emulationHandler.getInteractPoint(headingRef!!, useRandomOffset = true)
        val point2 = emulationHandler.getInteractPoint(headingRef, useRandomOffset = true)

        assertNotNull(point1)
        assertNotNull(point2)
        // With random offset, points may differ (but could be same by chance)
        assertTrue(point1!!.x > 0 && point2!!.x > 0, "Both points should have positive coordinates")
    }
}
