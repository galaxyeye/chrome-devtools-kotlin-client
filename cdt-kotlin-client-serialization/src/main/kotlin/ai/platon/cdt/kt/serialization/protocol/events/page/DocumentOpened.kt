@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.Frame

/**
 * Fired when opening document to write to.
 */
@Experimental
@Serializable
data class DocumentOpened(
  @SerialName("frame")
  val frame: Frame,
)
