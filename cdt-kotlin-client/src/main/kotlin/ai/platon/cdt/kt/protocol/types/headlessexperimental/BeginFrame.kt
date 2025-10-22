package ai.platon.cdt.kt.protocol.types.headlessexperimental

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

public data class BeginFrame(
  @field:JsonProperty("hasDamage")
  public val hasDamage: Boolean,
  @field:JsonProperty("screenshotData")
  @param:Optional
  public val screenshotData: String? = null,
)
