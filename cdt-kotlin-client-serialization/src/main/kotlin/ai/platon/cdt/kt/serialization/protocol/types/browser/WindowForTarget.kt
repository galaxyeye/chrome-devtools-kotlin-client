@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindowForTarget(
  @property:SerialName("windowId")
  val windowId: Int,
  @property:SerialName("bounds")
  val bounds: Bounds,
)
