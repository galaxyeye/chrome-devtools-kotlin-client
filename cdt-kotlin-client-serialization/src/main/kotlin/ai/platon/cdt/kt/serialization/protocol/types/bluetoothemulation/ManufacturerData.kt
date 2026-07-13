@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stores the manufacturer data
 */
@Serializable
data class ManufacturerData(
  @property:SerialName("key")
  val key: Int,
  @property:SerialName("data")
  val `data`: String,
)
