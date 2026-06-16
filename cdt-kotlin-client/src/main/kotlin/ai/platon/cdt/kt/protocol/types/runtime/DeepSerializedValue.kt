@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String

/**
 * Represents deep serialized value.
 */
data class DeepSerializedValue(
  @param:JsonProperty("type")
  val type: DeepSerializedValueType,
  @param:JsonProperty("value")
  @param:Optional
  val `value`: Any? = null,
  @param:JsonProperty("objectId")
  @param:Optional
  val objectId: String? = null,
  @param:JsonProperty("weakLocalObjectReference")
  @param:Optional
  val weakLocalObjectReference: Int? = null,
)
