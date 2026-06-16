@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS coverage information.
 */
@Serializable
data class RuleUsage(
  @property:SerialName("styleSheetId")
  val styleSheetId: String,
  @property:SerialName("startOffset")
  val startOffset: Double,
  @property:SerialName("endOffset")
  val endOffset: Double,
  @property:SerialName("used")
  val used: Boolean,
)
