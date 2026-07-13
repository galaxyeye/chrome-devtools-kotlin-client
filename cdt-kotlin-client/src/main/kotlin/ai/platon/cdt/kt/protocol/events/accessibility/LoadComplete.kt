@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.accessibility.AXNode
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The loadComplete event mirrors the load complete event sent by the browser to assistive
 * technology when the web page has finished loading.
 */
@Experimental
data class LoadComplete(
  @param:JsonProperty("root")
  val root: AXNode,
)
