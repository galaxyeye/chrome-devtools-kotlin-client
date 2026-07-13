@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Stores the manufacturer data
 */
data class ManufacturerData(
  @param:JsonProperty("key")
  val key: Int,
  @param:JsonProperty("data")
  val `data`: String,
)
