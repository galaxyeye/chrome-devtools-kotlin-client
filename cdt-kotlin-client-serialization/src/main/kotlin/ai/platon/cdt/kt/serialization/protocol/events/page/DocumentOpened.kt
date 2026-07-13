@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.Frame
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when opening document to write to.
 */
@Serializable
@Experimental
data class DocumentOpened(
  @property:SerialName("frame")
  val frame: Frame,
)
