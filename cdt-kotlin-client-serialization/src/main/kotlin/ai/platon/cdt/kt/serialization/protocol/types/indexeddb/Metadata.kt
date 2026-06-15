@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

@Serializable
data class Metadata(
  @SerialName("entriesCount")
  val entriesCount: Double,
  @SerialName("keyGeneratorValue")
  val keyGeneratorValue: Double,
)
