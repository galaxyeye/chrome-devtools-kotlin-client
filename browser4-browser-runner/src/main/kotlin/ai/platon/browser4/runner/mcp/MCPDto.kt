package ai.platon.browser4.runner.mcp

import kotlinx.serialization.Serializable

/**
 * Minimal MCP DTOs matching the wire format of [ai.platon.pulsar.rest.mcp.controller.MCPToolController].
 */
@Serializable
data class MCPToolCallRequest(
    val tool: String,
    val arguments: Map<String, String>? = null
)

@Serializable
data class MCPToolCallResponse(
    val content: List<MCPContent>,
    val isError: Boolean = false
)

@Serializable
data class MCPContent(
    val type: String = "text",
    val text: String
)
