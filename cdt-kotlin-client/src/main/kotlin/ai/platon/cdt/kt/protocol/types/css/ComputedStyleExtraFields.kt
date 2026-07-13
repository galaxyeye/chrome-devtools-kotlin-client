@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

@Experimental
data class ComputedStyleExtraFields(
  @param:JsonProperty("isAppearanceBase")
  val isAppearanceBase: Boolean,
)
