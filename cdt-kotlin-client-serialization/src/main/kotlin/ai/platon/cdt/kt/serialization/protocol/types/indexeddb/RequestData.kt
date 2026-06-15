@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.collections.List

@Serializable
data class RequestData(
  @SerialName("objectStoreDataEntries")
  val objectStoreDataEntries: List<DataEntry>,
  @SerialName("hasMore")
  val hasMore: Boolean,
)
