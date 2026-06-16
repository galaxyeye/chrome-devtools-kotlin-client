@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Error while paring app manifest.
 */
@Serializable
data class AppManifestError(
  @property:SerialName("message")
  val message: String,
  @property:SerialName("critical")
  val critical: Int,
  @property:SerialName("line")
  val line: Int,
  @property:SerialName("column")
  val column: Int,
)
