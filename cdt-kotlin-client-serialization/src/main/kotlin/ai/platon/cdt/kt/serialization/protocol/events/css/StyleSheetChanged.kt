@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Fired whenever a stylesheet is changed as a result of the client operation.
 */
@Serializable
data class StyleSheetChanged(
  @SerialName("styleSheetId")
  val styleSheetId: String,
)
