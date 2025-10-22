package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class Navigate(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("loaderId")
  @param:Optional
  val loaderId: String? = null,
  @field:JsonProperty("errorText")
  @param:Optional
  val errorText: String? = null,
)
