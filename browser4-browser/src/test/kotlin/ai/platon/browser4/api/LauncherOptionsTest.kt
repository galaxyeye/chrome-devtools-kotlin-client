package ai.platon.browser4.api

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Duration

class LauncherOptionsTest {

    @Test
    @DisplayName("default startup wait time is 60 seconds")
    fun defaultStartupWaitTimeIs60Seconds() {
        assertEquals(Duration.ofSeconds(60), LauncherOptions.DEFAULT_STARTUP_WAIT_TIME)
    }

    @Test
    @DisplayName("default shutdown wait time is 60 seconds")
    fun defaultShutdownWaitTimeIs60Seconds() {
        assertEquals(Duration.ofSeconds(60), LauncherOptions.DEFAULT_SHUTDOWN_WAIT_TIME)
    }

    @Test
    @DisplayName("thread join wait time is 5 seconds")
    fun threadJoinWaitTimeIs5Seconds() {
        assertEquals(Duration.ofSeconds(5), LauncherOptions.THREAD_JOIN_WAIT_TIME)
    }

    @Test
    @DisplayName("constructor initializes with default BrowserSettings")
    fun constructorInitializesWithDefaults() {
        val opts = LauncherOptions()
        assertNotNull(opts.settings)
        assertEquals(LauncherOptions.DEFAULT_STARTUP_WAIT_TIME, opts.startupWaitTime)
        assertEquals(LauncherOptions.DEFAULT_SHUTDOWN_WAIT_TIME, opts.shutdownWaitTime)
    }

    @Test
    @DisplayName("supervisor process can be set")
    fun supervisorProcessCanBeSet() {
        val opts = LauncherOptions(supervisorProcess = "custom-process")
        assertEquals("custom-process", opts.supervisorProcess)
    }

    @Test
    @DisplayName("supervisor process args mutable list")
    fun supervisorProcessArgsIsMutable() {
        val opts = LauncherOptions()
        opts.supervisorProcessArgs.add("--verbose")
        assertEquals(1, opts.supervisorProcessArgs.size)
    }
}
