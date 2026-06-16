@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Text range within a resource. All numbers are zero-based.
 */
@Serializable
data class SourceRange(
  @property:SerialName("startLine")
  val startLine: Int,
  @property:SerialName("startColumn")
  val startColumn: Int,
  @property:SerialName("endLine")
  val endLine: Int,
  @property:SerialName("endColumn")
  val endColumn: Int,
)
