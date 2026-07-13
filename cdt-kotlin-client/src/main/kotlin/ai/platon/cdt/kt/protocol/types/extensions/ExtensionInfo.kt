@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.extensions

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Detailed information about an extension.
 */
data class ExtensionInfo(
  @param:JsonProperty("id")
  val id: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("version")
  val version: String,
  @param:JsonProperty("path")
  val path: String,
  @param:JsonProperty("enabled")
  val enabled: Boolean,
)
