@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.page

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.types.page.Frame
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
