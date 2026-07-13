@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage

import kotlin.Double
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestEntries(
  @property:SerialName("cacheDataEntries")
  val cacheDataEntries: List<DataEntry>,
  @property:SerialName("returnCount")
  val returnCount: Double,
)
