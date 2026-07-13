@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Represents options for serialization. Overrides `generatePreview` and `returnByValue`.
 */
data class SerializationOptions(
  @param:JsonProperty("serialization")
  val serialization: SerializationOptionsSerialization,
  @param:JsonProperty("maxDepth")
  @param:Optional
  val maxDepth: Int? = null,
  @param:JsonProperty("additionalParameters")
  @param:Optional
  val additionalParameters: Map<String, Any?>? = null,
)
