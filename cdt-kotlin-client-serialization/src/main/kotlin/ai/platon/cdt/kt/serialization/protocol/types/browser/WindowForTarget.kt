@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

@Serializable
data class WindowForTarget(
  @SerialName("windowId")
  val windowId: Int,
  @SerialName("bounds")
  val bounds: Bounds,
)
