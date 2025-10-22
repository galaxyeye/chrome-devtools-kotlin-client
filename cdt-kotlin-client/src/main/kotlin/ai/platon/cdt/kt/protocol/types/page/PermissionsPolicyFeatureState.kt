package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

@Experimental
public data class PermissionsPolicyFeatureState(
  @field:JsonProperty("feature")
  public val feature: PermissionsPolicyFeature,
  @field:JsonProperty("allowed")
  public val allowed: Boolean,
  @field:JsonProperty("locator")
  @param:Optional
  public val locator: PermissionsPolicyBlockLocator? = null,
)
