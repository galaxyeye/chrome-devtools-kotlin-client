@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
  @property:SerialName("entriesCount")
  val entriesCount: Double,
  @property:SerialName("keyGeneratorValue")
  val keyGeneratorValue: Double,
)
