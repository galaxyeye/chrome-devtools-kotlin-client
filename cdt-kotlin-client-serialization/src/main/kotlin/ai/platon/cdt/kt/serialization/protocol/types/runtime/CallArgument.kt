@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Represents function call argument. Either remote object id `objectId`, primitive `value`,
 * unserializable primitive value or neither of (for undefined) them should be specified.
 */
@Serializable
data class CallArgument(
  @property:SerialName("value")
  @param:Optional
  val `value`: JsonElement? = null,
  @property:SerialName("unserializableValue")
  @param:Optional
  val unserializableValue: String? = null,
  @property:SerialName("objectId")
  @param:Optional
  val objectId: String? = null,
)
