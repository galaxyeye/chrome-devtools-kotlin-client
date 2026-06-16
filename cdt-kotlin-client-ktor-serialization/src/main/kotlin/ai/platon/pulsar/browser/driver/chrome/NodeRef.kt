package ai.platon.pulsar.browser.driver.chrome

/**
 * NodeId does not explicitly prohibit 0, but as seen in the internal implementation (Chromium source code):
 * - All valid nodes are assigned NodeIds starting from 1
 * - `0` is reserved as an "invalid / null node"
 *
 * DOM.NodeId #
 * Unique DOM node identifier.
 * Type: integer
 *
 * DOM.BackendNodeId #
 * Unique DOM node identifier used to reference a node that may not have been pushed to the front-end.
 * Type: integer
 *
 * References:
 * - [NodeId](https://chromedevtools.github.io/devtools-protocol/tot/DOM/#type-NodeId)
 */
data class NodeRef constructor(
    val nodeId: Int = 0,
    // backend node id is more stable
    val backendNodeId: Int = 0,
    // objectId is ephemeral; do not cache across calls. Always resolve a fresh objectId when needed.
    val objectId: String? = null
) {
    // Playwright compatible selector for backend node id, e.g. "e12345" for backendNodeId 12345
    val selector get() = "e$backendNodeId"

    /**
     * Check if the node may exist.
     *
     * At least one of nodeId and backendNodeId is positive.
     */
    fun mayExist(): Boolean {
        return nodeId > 0 || backendNodeId > 0
    }

    fun isNull(): Boolean {
        return nodeId == 0 && backendNodeId == 0
    }
}
