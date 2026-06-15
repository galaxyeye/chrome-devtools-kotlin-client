@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Fired whenever an active document stylesheet is removed.
 */
@Serializable
data class StyleSheetRemoved(
  @SerialName("styleSheetId")
  val styleSheetId: String,
)
