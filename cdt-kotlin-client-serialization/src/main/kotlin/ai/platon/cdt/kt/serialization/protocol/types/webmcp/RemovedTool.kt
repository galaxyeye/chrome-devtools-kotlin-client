@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webmcp

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Definition of a tool that was removed.
 */
@Serializable
data class RemovedTool(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("frameId")
  val frameId: String,
)
