@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List

data class AppManifest(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("errors")
  val errors: List<AppManifestError>,
  @param:JsonProperty("data")
  @param:Optional
  val `data`: String? = null,
  @param:JsonProperty("parsed")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  @param:Experimental
  val parsed: AppManifestParsedProperties? = null,
  @param:JsonProperty("manifest")
  @param:Experimental
  val manifest: WebAppManifest,
)
