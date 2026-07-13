package ai.platon.browser4.chrome.protocol

import ai.platon.browser4.api.BrowserProtocol
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class KeyboardTest {

    private val mockProtocol = mock<BrowserProtocol>()
    private val keyboard = Keyboard(mockProtocol)

    @Test
    @DisplayName("splitKeyString handles single character")
    fun splitKeyStringHandlesSingleChar() {
        assertEquals(listOf("a"), keyboard.splitKeyString("a"))
    }

    @Test
    @DisplayName("splitKeyString handles Shift+key combination")
    fun splitKeyStringHandlesShiftCombination() {
        val parts = keyboard.splitKeyString("Shift+A")
        assertEquals(listOf("Shift", "A"), parts)
    }

    @Test
    @DisplayName("splitKeyString handles Ctrl+Shift+Tab")
    fun splitKeyStringHandlesMultipleModifiers() {
        val parts = keyboard.splitKeyString("Control+Shift+Tab")
        assertEquals(listOf("Control", "Shift", "Tab"), parts)
    }

    @Test
    @DisplayName("splitKeyString handles Alt+F4")
    fun splitKeyStringHandlesAltCombination() {
        val parts = keyboard.splitKeyString("Alt+F4")
        assertEquals(listOf("Alt", "F4"), parts)
    }

    @Test
    @DisplayName("splitKeyString handles single named key")
    fun splitKeyStringHandlesSingleNamedKey() {
        assertEquals(listOf("Enter"), keyboard.splitKeyString("Enter"))
        assertEquals(listOf("Escape"), keyboard.splitKeyString("Escape"))
        assertEquals(listOf("Tab"), keyboard.splitKeyString("Tab"))
    }

    @Test
    @DisplayName("splitKeyString handles Backspace and arrows")
    fun splitKeyStringHandlesSpecialKeys() {
        assertEquals(listOf("Backspace"), keyboard.splitKeyString("Backspace"))
        assertEquals(listOf("ArrowDown"), keyboard.splitKeyString("ArrowDown"))
        assertEquals(listOf("PageUp"), keyboard.splitKeyString("PageUp"))
    }

    @Test
    @DisplayName("splitKeyString handles Meta+key")
    fun splitKeyStringHandlesMetaKey() {
        val parts = keyboard.splitKeyString("Meta+C")
        assertEquals(listOf("Meta", "C"), parts)
    }

    @Test
    @DisplayName("createVirtualKeyForSingleKeyString returns non-null for letter")
    fun createVirtualKeyForLetter() {
        val key = keyboard.createVirtualKeyForSingleKeyString("a")
        assertNotNull(key)
    }

    @Test
    @DisplayName("createVirtualKeyForSingleKeyString returns non-null for Enter")
    fun createVirtualKeyForEnter() {
        val key = keyboard.createVirtualKeyForSingleKeyString("Enter")
        assertNotNull(key)
    }
}
