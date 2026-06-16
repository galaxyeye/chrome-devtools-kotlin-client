@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Mirror object referencing original JavaScript object.
 */
@Serializable
data class RemoteObject(
  @property:SerialName("type")
  val type: RemoteObjectType,
  @property:SerialName("subtype")
  @param:Optional
  val subtype: RemoteObjectSubtype? = null,
  @property:SerialName("className")
  @param:Optional
  val className: String? = null,
  @property:SerialName("value")
  @param:Optional
  val `value`: JsonElement? = null,
  @property:SerialName("unserializableValue")
  @param:Optional
  val unserializableValue: String? = null,
  @property:SerialName("description")
  @param:Optional
  val description: String? = null,
  @property:SerialName("objectId")
  @param:Optional
  val objectId: String? = null,
  @property:SerialName("preview")
  @param:Optional
  @param:Experimental
  val preview: ObjectPreview? = null,
  @property:SerialName("customPreview")
  @param:Optional
  @param:Experimental
  val customPreview: CustomPreview? = null,
)
