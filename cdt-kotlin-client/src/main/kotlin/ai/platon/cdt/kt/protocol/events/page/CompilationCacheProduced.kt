package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Issued for every compilation cache generated. Is only available
 * if Page.setGenerateCompilationCache is enabled.
 */
@Experimental
data class CompilationCacheProduced(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("data")
  val `data`: String,
)
