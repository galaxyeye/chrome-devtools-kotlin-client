@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired whenever an active document stylesheet is removed.
 */
@Serializable
data class StyleSheetRemoved(
  @property:SerialName("styleSheetId")
  val styleSheetId: String,
)
