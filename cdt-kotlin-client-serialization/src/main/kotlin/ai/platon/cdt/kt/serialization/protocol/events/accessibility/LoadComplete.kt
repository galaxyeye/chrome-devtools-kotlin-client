@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.accessibility

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.accessibility.AXNode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The loadComplete event mirrors the load complete event sent by the browser to assistive
 * technology when the web page has finished loading.
 */
@Serializable
@Experimental
data class LoadComplete(
  @property:SerialName("root")
  val root: AXNode,
)
