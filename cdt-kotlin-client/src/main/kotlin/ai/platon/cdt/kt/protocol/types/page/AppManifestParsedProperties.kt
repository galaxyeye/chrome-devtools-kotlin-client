package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Parsed app manifest properties.
 */
@Experimental
data class AppManifestParsedProperties(
  @field:JsonProperty("scope")
  val scope: String,
)
