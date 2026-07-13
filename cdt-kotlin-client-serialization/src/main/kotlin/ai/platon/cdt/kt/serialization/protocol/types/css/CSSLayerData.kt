@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS Layer data.
 */
@Serializable
@Experimental
data class CSSLayerData(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("subLayers")
  @param:Optional
  val subLayers: List<CSSLayerData>? = null,
  @property:SerialName("order")
  val order: Double,
)
