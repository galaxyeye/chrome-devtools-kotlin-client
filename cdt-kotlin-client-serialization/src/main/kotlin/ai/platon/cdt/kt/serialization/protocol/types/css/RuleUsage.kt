@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * CSS coverage information.
 */
@Serializable
data class RuleUsage(
  @SerialName("styleSheetId")
  val styleSheetId: String,
  @SerialName("startOffset")
  val startOffset: Double,
  @SerialName("endOffset")
  val endOffset: Double,
  @SerialName("used")
  val used: Boolean,
)
