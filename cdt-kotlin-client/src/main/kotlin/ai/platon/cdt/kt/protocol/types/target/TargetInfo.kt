package ai.platon.cdt.kt.protocol.types.target

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

public data class TargetInfo(
  @field:JsonProperty("targetId")
  public val targetId: String,
  @field:JsonProperty("type")
  public val type: String,
  @field:JsonProperty("title")
  public val title: String,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("attached")
  public val attached: Boolean,
  @field:JsonProperty("openerId")
  @param:Optional
  public val openerId: String? = null,
  @field:JsonProperty("canAccessOpener")
  @param:Experimental
  public val canAccessOpener: Boolean,
  @field:JsonProperty("openerFrameId")
  @param:Optional
  @param:Experimental
  public val openerFrameId: String? = null,
  @field:JsonProperty("browserContextId")
  @param:Optional
  @param:Experimental
  public val browserContextId: String? = null,
)
