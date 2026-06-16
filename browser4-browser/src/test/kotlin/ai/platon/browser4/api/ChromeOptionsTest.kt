package ai.platon.browser4.api

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ChromeOptionsTest {

    @Test
    @DisplayName("default options produce correct CLI flags")
    fun defaultOptionsProduceCorrectCliFlags() {
        val opts = ChromeOptions()
        val args = opts.toList()

        // headless defaults to false, so it should NOT appear
        assertFalse(args.any { it.startsWith("--headless") }, "headless defaults to false - should not appear")
        // These default to true
        assertTrue(args.contains("--disable-gpu"), "disableGpu defaults to true")
        assertTrue(args.contains("--no-first-run"), "noFirstRun defaults to true")
        // noSandbox defaults to false
        assertFalse(args.any { it.startsWith("--no-sandbox") }, "noSandbox defaults to false")
    }

    @Test
    @DisplayName("headless enabled produces flag without value")
    fun headlessEnabledProducesFlagWithoutValue() {
        val opts = ChromeOptions(headless = true)
        val args = opts.toList()
        assertTrue(args.contains("--headless"))
    }

    @Test
    @DisplayName("headless disabled omits flag")
    fun headlessDisabledOmitsFlag() {
        val opts = ChromeOptions(headless = false)
        val args = opts.toList()
        assertFalse(args.contains("--headless"))
    }

    @Test
    @DisplayName("proxyServer set produces key=value format")
    fun proxyServerProducesKeyValueFormat() {
        val opts = ChromeOptions(proxyServer = "http://proxy:8080")
        val args = opts.toList()
        assertTrue(args.contains("--proxy-server=http://proxy:8080"))
    }

    @Test
    @DisplayName("proxyServer null omits flag")
    fun proxyServerNullOmitsFlag() {
        val opts = ChromeOptions(proxyServer = null)
        val args = opts.toList()
        assertFalse(args.any { it.startsWith("--proxy-server") })
    }

    @Test
    @DisplayName("remoteDebuggingPort set to non-zero produces flag")
    fun remoteDebuggingPortSetProducesFlag() {
        val opts = ChromeOptions(remoteDebuggingPort = 9222)
        val args = opts.toList()
        assertTrue(args.contains("--remote-debugging-port=9222"))
    }

    @Test
    @DisplayName("remoteDebuggingPort zero still produces flag with zero value")
    fun remoteDebuggingPortZeroProducesZeroFlag() {
        val opts = ChromeOptions(remoteDebuggingPort = 0)
        val args = opts.toList()
        assertTrue(args.contains("--remote-debugging-port=0"), "0 is not treated as falsy")
    }

    @Test
    @DisplayName("disableExtensions true produces flag")
    fun disableExtensionsTrueProducesFlag() {
        val opts = ChromeOptions(disableExtensions = true)
        val args = opts.toList()
        assertTrue(args.contains("--disable-extensions"))
    }

    @Test
    @DisplayName("noStartupWindow true produces flag")
    fun noStartupWindowTrueProducesFlag() {
        val opts = ChromeOptions(noStartupWindow = true)
        val args = opts.toList()
        assertTrue(args.contains("--no-startup-window"))
    }

    @Test
    @DisplayName("addArgument with value produces key=value")
    fun addArgumentWithValueProducesKeyValue() {
        val opts = ChromeOptions()
        opts.addArgument("custom-flag", "custom-value")
        val args = opts.toList()
        assertTrue(args.contains("--custom-flag=custom-value"))
    }

    @Test
    @DisplayName("addArgument with boolean true value produces flag without value")
    fun addArgumentWithBooleanTrueProducesFlagOnly() {
        val opts = ChromeOptions()
        opts.additionalArguments["enable-feature"] = true
        val args = opts.toList()
        assertTrue(args.contains("--enable-feature"))
    }

    @Test
    @DisplayName("removeArgument removes previously added argument")
    fun removeArgumentRemovesAddedArgument() {
        val opts = ChromeOptions()
        opts.addArgument("temp-flag", "temp-value")
        opts.removeArgument("temp-flag")
        val args = opts.toList()
        assertFalse(args.any { it.startsWith("--temp-flag") })
    }

    @Test
    @DisplayName("merge converts Boolean to String and produces key=value format")
    fun mergeConvertsBooleanToString() {
        val opts = ChromeOptions()
        // merge converts all values via toString(), so Boolean true becomes "true" (String)
        opts.merge(mapOf("flag-a" to true, "flag-b" to "value-b"))
        val args = opts.toList()
        // "true" != true in Kotlin, so it goes to --flag-a=true (key=value)
        assertTrue(args.contains("--flag-a=true"), "Boolean true is toString'd to 'true' string")
        assertTrue(args.contains("--flag-b=value-b"), "String value passes through")
    }

    @Test
    @DisplayName("toMap includes annotated fields and additional arguments")
    fun toMapIncludesAnnotatedFieldsAndAdditionalArgs() {
        val opts = ChromeOptions(headless = true, proxyServer = "http://p:8080")
        opts.addArgument("extra", "yes")
        val map = opts.toMap()
        assertEquals(true, map["headless"])
        assertEquals("http://p:8080", map["proxy-server"])
        assertEquals("yes", map["extra"])
    }

    @Test
    @DisplayName("toString joins arguments with spaces")
    fun toStringJoinsArgumentsWithSpaces() {
        val opts = ChromeOptions(headless = true, disableGpu = true)
        val str = opts.toString()
        assertTrue(str.contains("--headless"))
        assertTrue(str.contains("--disable-gpu"))
        assertTrue(str.contains(" "))
    }

    @Test
    @DisplayName("incognito true produces flag")
    fun incognitoTrueProducesFlag() {
        val opts = ChromeOptions(incognito = true)
        val args = opts.toList()
        assertTrue(args.contains("--incognito"))
    }

    @Test
    @DisplayName("ignoreCertificateErrors true produces flag")
    fun ignoreCertificateErrorsProducesFlag() {
        val opts = ChromeOptions(ignoreCertificateErrors = true)
        val args = opts.toList()
        assertTrue(args.contains("--ignore-certificate-errors"))
    }

    @Test
    @DisplayName("all default booleans produce correct flags")
    fun allDefaultBooleansProduceCorrectFlags() {
        val opts = ChromeOptions()
        val args = opts.toList()

        // These default to true, so should appear
        assertTrue(args.contains("--disable-gpu"))
        assertTrue(args.contains("--hide-scrollbars"))
        assertTrue(args.contains("--no-default-browser-check"))
        assertTrue(args.contains("--no-first-run"))
        assertTrue(args.contains("--no-startup-window"))
        assertTrue(args.contains("--mute-audio"))
        assertTrue(args.contains("--disable-background-networking"))

        // These default to false, so should NOT appear
        assertFalse(args.any { it.startsWith("--incognito") })
        assertFalse(args.any { it.startsWith("--disable-extensions") })
    }
}
