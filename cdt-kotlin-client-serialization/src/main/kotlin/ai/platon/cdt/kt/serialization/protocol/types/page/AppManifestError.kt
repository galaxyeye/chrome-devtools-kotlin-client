@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Error while paring app manifest.
 */
@Serializable
data class AppManifestError(
  @SerialName("message")
  val message: String,
  @SerialName("critical")
  val critical: Int,
  @SerialName("line")
  val line: Int,
  @SerialName("column")
  val column: Int,
)
