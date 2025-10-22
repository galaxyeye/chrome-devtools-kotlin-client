package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class Navigate(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("loaderId")
  @param:Optional
  public val loaderId: String? = null,
  @field:JsonProperty("errorText")
  @param:Optional
  public val errorText: String? = null,
)
