package ai.platon.pulsar.browser.driver.chrome

import ai.platon.cdt.kt.serialization.protocol.types.network.LoadNetworkResourcePageResult

class NetworkResourceResponse(
    val success: Boolean = false,
    val netError: Int = 0,
    val netErrorName: String = "",
    /** Request isn't made */
    val httpStatusCode: Int = 0,
    val stream: String? = null,
    val headers: Map<String, Any?>? = null,
) {
    companion object {
        fun from(res: LoadNetworkResourcePageResult): NetworkResourceResponse {
            val success = res.success
            val netError = res.netError?.toInt() ?: 0
            val netErrorName = res.netErrorName ?: ""
            val httpStatusCode = res.httpStatusCode?.toInt() ?: 400
            // All pulsar added headers have a prefix Q-
            val headers = res.headers?.toMutableMap() ?: mutableMapOf()
            return NetworkResourceResponse(success, netError, netErrorName, httpStatusCode, res.stream, headers)
        }
    }
}
