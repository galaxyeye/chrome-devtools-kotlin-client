@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.FileChooserOpenedMode
import kotlin.Int
import kotlin.String

/**
 * Emitted only when `page.interceptFileChooser` is enabled.
 */
@Serializable
data class FileChooserOpened(
  @SerialName("frameId")
  @param:Experimental
  val frameId: String,
  @SerialName("backendNodeId")
  @param:Experimental
  val backendNodeId: Int,
  @SerialName("mode")
  val mode: FileChooserOpenedMode,
)
