package ai.platon.browser4.chrome.examples

class EventsExample: BrowserExampleBase() {
    override suspend fun run() {
        devTools.networkEnable()
        devTools.pageEnable()
        devTools.navigate(testUrl)
    }
}

suspend fun main() {
    EventsExample().use { it.run() }
}
