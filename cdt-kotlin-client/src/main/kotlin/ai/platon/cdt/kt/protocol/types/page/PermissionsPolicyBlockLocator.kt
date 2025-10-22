package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class PermissionsPolicyBlockLocator(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("blockReason")
  public val blockReason: PermissionsPolicyBlockReason,
)
