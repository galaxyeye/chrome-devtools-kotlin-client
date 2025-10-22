package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class PrintToPDF(
  @field:JsonProperty("data")
  val `data`: String,
  @field:JsonProperty("stream")
  @param:Optional
  @param:Experimental
  val stream: String? = null,
)
