package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.page.FileChooserOpenedMode
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Emitted only when `page.interceptFileChooser` is enabled.
 */
data class FileChooserOpened(
  @field:JsonProperty("frameId")
  @param:Experimental
  val frameId: String,
  @field:JsonProperty("backendNodeId")
  @param:Experimental
  val backendNodeId: Int,
  @field:JsonProperty("mode")
  val mode: FileChooserOpenedMode,
)
