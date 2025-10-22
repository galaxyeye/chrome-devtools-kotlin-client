package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class AppManifest(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("errors")
  val errors: List<AppManifestError>,
  @field:JsonProperty("data")
  @param:Optional
  val `data`: String? = null,
  @field:JsonProperty("parsed")
  @param:Optional
  @param:Experimental
  val parsed: AppManifestParsedProperties? = null,
)
