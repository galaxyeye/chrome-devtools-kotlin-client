@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Text range within a resource. All numbers are zero-based.
 */
@Serializable
data class SourceRange(
  @SerialName("startLine")
  val startLine: Int,
  @SerialName("startColumn")
  val startColumn: Int,
  @SerialName("endLine")
  val endLine: Int,
  @SerialName("endColumn")
  val endColumn: Int,
)
