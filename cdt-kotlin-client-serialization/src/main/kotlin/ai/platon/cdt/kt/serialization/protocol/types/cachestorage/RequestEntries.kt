@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.collections.List

@Serializable
data class RequestEntries(
  @SerialName("cacheDataEntries")
  val cacheDataEntries: List<DataEntry>,
  @SerialName("returnCount")
  val returnCount: Double,
)
