@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.backgroundservice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * A key-value pair for additional event information to pass along.
 */
@Serializable
data class EventMetadata(
  @SerialName("key")
  val key: String,
  @SerialName("value")
  val `value`: String,
)
