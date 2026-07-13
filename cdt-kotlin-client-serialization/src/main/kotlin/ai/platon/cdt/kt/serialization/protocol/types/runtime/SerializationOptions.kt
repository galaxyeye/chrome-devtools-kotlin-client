@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Represents options for serialization. Overrides `generatePreview` and `returnByValue`.
 */
@Serializable
data class SerializationOptions(
  @property:SerialName("serialization")
  val serialization: SerializationOptionsSerialization,
  @property:SerialName("maxDepth")
  @param:Optional
  val maxDepth: Int? = null,
  @property:SerialName("additionalParameters")
  @param:Optional
  val additionalParameters: JsonObject? = null,
)
