package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class PermissionsPolicyBlockLocator(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("blockReason")
  val blockReason: PermissionsPolicyBlockReason,
)
