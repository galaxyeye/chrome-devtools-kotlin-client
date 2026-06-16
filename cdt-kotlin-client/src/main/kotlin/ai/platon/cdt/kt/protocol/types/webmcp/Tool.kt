@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.webmcp

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Definition of a tool that can be invoked.
 */
data class Tool(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("description")
  val description: String,
  @param:JsonProperty("inputSchema")
  @param:Optional
  val inputSchema: Map<String, Any?>? = null,
  @param:JsonProperty("annotations")
  @param:Optional
  val annotations: Annotation? = null,
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @param:JsonProperty("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
)
