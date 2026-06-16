@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.extensions

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed information about an extension.
 */
@Serializable
data class ExtensionInfo(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("version")
  val version: String,
  @property:SerialName("path")
  val path: String,
  @property:SerialName("enabled")
  val enabled: Boolean,
)
