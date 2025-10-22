package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String

/**
 * Mirror object referencing original JavaScript object.
 */
data class RemoteObject(
  @field:JsonProperty("type")
  val type: RemoteObjectType,
  @field:JsonProperty("subtype")
  @param:Optional
  val subtype: RemoteObjectSubtype? = null,
  @field:JsonProperty("className")
  @param:Optional
  val className: String? = null,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: Any? = null,
  @field:JsonProperty("unserializableValue")
  @param:Optional
  val unserializableValue: String? = null,
  @field:JsonProperty("description")
  @param:Optional
  val description: String? = null,
  @field:JsonProperty("objectId")
  @param:Optional
  val objectId: String? = null,
  @field:JsonProperty("preview")
  @param:Optional
  @param:Experimental
  val preview: ObjectPreview? = null,
  @field:JsonProperty("customPreview")
  @param:Optional
  @param:Experimental
  val customPreview: CustomPreview? = null,
)
