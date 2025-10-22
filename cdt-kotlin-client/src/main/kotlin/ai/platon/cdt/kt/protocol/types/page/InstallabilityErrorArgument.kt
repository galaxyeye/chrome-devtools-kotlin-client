package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class InstallabilityErrorArgument(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
)
