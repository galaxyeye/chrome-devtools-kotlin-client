@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.String

/**
 * Mirror object referencing original JavaScript object.
 */
@Serializable
data class RemoteObject(
  @SerialName("type")
  val type: RemoteObjectType,
  @SerialName("subtype")
  @param:Optional
  val subtype: RemoteObjectSubtype? = null,
  @SerialName("className")
  @param:Optional
  val className: String? = null,
  @SerialName("value")
  @param:Optional
  val `value`: Any? = null,
  @SerialName("unserializableValue")
  @param:Optional
  val unserializableValue: String? = null,
  @SerialName("description")
  @param:Optional
  val description: String? = null,
  @SerialName("objectId")
  @param:Optional
  val objectId: String? = null,
  @SerialName("preview")
  @param:Optional
  @param:Experimental
  val preview: ObjectPreview? = null,
  @SerialName("customPreview")
  @param:Optional
  @param:Experimental
  val customPreview: CustomPreview? = null,
)
