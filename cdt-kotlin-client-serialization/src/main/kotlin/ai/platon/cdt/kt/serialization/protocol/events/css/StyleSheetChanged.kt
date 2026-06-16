@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired whenever a stylesheet is changed as a result of the client operation.
 */
@Serializable
data class StyleSheetChanged(
  @property:SerialName("styleSheetId")
  val styleSheetId: String,
)
