@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.input

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Experimental
data class DragData(
  @param:JsonProperty("items")
  val items: List<DragDataItem>,
  @param:JsonProperty("files")
  @param:Optional
  val files: List<String>? = null,
  @param:JsonProperty("dragOperationsMask")
  val dragOperationsMask: Int,
)
