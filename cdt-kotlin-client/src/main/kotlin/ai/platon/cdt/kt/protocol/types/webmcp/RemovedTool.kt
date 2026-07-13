@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.webmcp

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Definition of a tool that was removed.
 */
data class RemovedTool(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("frameId")
  val frameId: String,
)
