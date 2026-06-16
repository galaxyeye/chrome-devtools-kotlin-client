@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.page.FileChooserOpenedMode
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Emitted only when `page.interceptFileChooser` is enabled.
 */
@Serializable
data class FileChooserOpened(
  @property:SerialName("frameId")
  @param:Experimental
  val frameId: String,
  @property:SerialName("mode")
  val mode: FileChooserOpenedMode,
  @property:SerialName("backendNodeId")
  @param:Optional
  @param:Experimental
  val backendNodeId: Int? = null,
)
