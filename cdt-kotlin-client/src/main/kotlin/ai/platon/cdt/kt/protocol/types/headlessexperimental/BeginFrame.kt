package ai.platon.cdt.kt.protocol.types.headlessexperimental

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class BeginFrame(
  @field:JsonProperty("hasDamage")
  val hasDamage: Boolean,
  @field:JsonProperty("screenshotData")
  @param:Optional
  val screenshotData: String? = null,
)
