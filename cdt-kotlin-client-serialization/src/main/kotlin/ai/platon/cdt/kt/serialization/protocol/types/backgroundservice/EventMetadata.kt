@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.backgroundservice

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A key-value pair for additional event information to pass along.
 */
@Serializable
data class EventMetadata(
  @property:SerialName("key")
  val key: String,
  @property:SerialName("value")
  val `value`: String,
)
