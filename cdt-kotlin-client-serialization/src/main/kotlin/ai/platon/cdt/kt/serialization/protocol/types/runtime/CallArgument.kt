@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.String

/**
 * Represents function call argument. Either remote object id `objectId`, primitive `value`,
 * unserializable primitive value or neither of (for undefined) them should be specified.
 */
@Serializable
data class CallArgument(
  @SerialName("value")
  @param:Optional
  val `value`: Any? = null,
  @SerialName("unserializableValue")
  @param:Optional
  val unserializableValue: String? = null,
  @SerialName("objectId")
  @param:Optional
  val objectId: String? = null,
)
