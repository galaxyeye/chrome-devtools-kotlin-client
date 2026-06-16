@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class DragData(
  @property:SerialName("items")
  val items: List<DragDataItem>,
  @property:SerialName("files")
  @param:Optional
  val files: List<String>? = null,
  @property:SerialName("dragOperationsMask")
  val dragOperationsMask: Int,
)
