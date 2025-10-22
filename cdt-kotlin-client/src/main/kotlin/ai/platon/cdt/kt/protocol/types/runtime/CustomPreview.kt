package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class CustomPreview(
  @field:JsonProperty("header")
  val `header`: String,
  @field:JsonProperty("bodyGetterId")
  @param:Optional
  val bodyGetterId: String? = null,
)
