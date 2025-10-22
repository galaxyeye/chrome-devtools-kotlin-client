package ai.platon.cdt.kt.protocol.types.input

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

@Experimental
data class DragData(
  @field:JsonProperty("items")
  val items: List<DragDataItem>,
  @field:JsonProperty("dragOperationsMask")
  val dragOperationsMask: Int,
)
