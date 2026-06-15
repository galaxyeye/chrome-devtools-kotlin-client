@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.collections.List

@Experimental
@Serializable
data class DragData(
  @SerialName("items")
  val items: List<DragDataItem>,
  @SerialName("dragOperationsMask")
  val dragOperationsMask: Int,
)
