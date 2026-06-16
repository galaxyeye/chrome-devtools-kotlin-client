package ai.platon.pulsar.browser.driver.examples

import ai.platon.pulsar.browser.driver.chrome.ChromeLauncher
import ai.platon.pulsar.common.browser.BrowserFiles

suspend fun main() {
    // val userDataDir = BrowserFiles.computeTestContextDir()
    val userDataDir = BrowserFiles.computeRandomTmpContextDir("test")
    val launcher = ChromeLauncher(userDataDir)
    val chrome = launcher.launch()
    val version = chrome.version
    println("version: $version")
    // BlockUrlsExample().use { it.run() }
}
