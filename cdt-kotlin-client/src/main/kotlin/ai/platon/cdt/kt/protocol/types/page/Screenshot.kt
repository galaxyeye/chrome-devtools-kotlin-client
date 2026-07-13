@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class Screenshot(
  @param:JsonProperty("image")
  val image: ImageResource,
  @param:JsonProperty("formFactor")
  val formFactor: String,
  @param:JsonProperty("label")
  @param:Optional
  val label: String? = null,
)
