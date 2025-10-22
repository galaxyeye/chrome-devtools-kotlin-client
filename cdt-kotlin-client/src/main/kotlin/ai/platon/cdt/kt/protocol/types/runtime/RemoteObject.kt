package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String

/**
 * Mirror object referencing original JavaScript object.
 */
public data class RemoteObject(
  @field:JsonProperty("type")
  public val type: RemoteObjectType,
  @field:JsonProperty("subtype")
  @param:Optional
  public val subtype: RemoteObjectSubtype? = null,
  @field:JsonProperty("className")
  @param:Optional
  public val className: String? = null,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: Any? = null,
  @field:JsonProperty("unserializableValue")
  @param:Optional
  public val unserializableValue: String? = null,
  @field:JsonProperty("description")
  @param:Optional
  public val description: String? = null,
  @field:JsonProperty("objectId")
  @param:Optional
  public val objectId: String? = null,
  @field:JsonProperty("preview")
  @param:Optional
  @param:Experimental
  public val preview: ObjectPreview? = null,
  @field:JsonProperty("customPreview")
  @param:Optional
  @param:Experimental
  public val customPreview: CustomPreview? = null,
)
