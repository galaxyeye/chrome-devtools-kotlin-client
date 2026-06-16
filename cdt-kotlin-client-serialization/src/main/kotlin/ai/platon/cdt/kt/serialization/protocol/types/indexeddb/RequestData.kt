@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestData(
  @property:SerialName("objectStoreDataEntries")
  val objectStoreDataEntries: List<DataEntry>,
  @property:SerialName("hasMore")
  val hasMore: Boolean,
)
