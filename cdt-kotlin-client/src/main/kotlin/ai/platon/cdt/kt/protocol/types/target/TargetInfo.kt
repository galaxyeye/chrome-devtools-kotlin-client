package ai.platon.cdt.kt.protocol.types.target

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class TargetInfo(
  @field:JsonProperty("targetId")
  val targetId: String,
  @field:JsonProperty("type")
  val type: String,
  @field:JsonProperty("title")
  val title: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("attached")
  val attached: Boolean,
  @field:JsonProperty("openerId")
  @param:Optional
  val openerId: String? = null,
  @field:JsonProperty("canAccessOpener")
  @param:Experimental
  val canAccessOpener: Boolean,
  @field:JsonProperty("openerFrameId")
  @param:Optional
  @param:Experimental
  val openerFrameId: String? = null,
  @field:JsonProperty("browserContextId")
  @param:Optional
  @param:Experimental
  val browserContextId: String? = null,
)
