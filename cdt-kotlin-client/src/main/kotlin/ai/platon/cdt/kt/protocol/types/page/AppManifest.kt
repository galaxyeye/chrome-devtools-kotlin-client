package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

public data class AppManifest(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("errors")
  public val errors: List<AppManifestError>,
  @field:JsonProperty("data")
  @param:Optional
  public val `data`: String? = null,
  @field:JsonProperty("parsed")
  @param:Optional
  @param:Experimental
  public val parsed: AppManifestParsedProperties? = null,
)
