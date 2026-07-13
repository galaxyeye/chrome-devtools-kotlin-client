package ai.platon.pulsar.browser.driver.chrome

class MethodInvocation(
    var id: Long = 0,
    var method: String,
    var params: Map<String, Any>? = null
) {
    override fun toString(): String {
        val parameters = params?.entries?.joinToString(", ") { it.key + ": " + "..." }
        return if (parameters != null) "$method($parameters)" else "$method()"
    }
}
