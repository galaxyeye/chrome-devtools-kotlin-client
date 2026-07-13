@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webmcp

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Definition of a tool that can be invoked.
 */
@Serializable
data class Tool(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("description")
  val description: String,
  @property:SerialName("inputSchema")
  @param:Optional
  val inputSchema: JsonObject? = null,
  @property:SerialName("annotations")
  @param:Optional
  val annotations: Annotation? = null,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @property:SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
)
