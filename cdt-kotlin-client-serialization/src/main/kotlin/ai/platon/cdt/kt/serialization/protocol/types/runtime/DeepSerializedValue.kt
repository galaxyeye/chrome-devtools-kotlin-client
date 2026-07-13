@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Represents deep serialized value.
 */
@Serializable
data class DeepSerializedValue(
  @property:SerialName("type")
  val type: DeepSerializedValueType,
  @property:SerialName("value")
  @param:Optional
  val `value`: JsonElement? = null,
  @property:SerialName("objectId")
  @param:Optional
  val objectId: String? = null,
  @property:SerialName("weakLocalObjectReference")
  @param:Optional
  val weakLocalObjectReference: Int? = null,
)
