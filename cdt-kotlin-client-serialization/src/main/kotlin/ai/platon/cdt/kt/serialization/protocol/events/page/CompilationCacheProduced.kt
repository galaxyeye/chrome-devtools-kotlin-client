@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Issued for every compilation cache generated. Is only available
 * if Page.setGenerateCompilationCache is enabled.
 */
@Experimental
@Serializable
data class CompilationCacheProduced(
  @SerialName("url")
  val url: String,
  @SerialName("data")
  val `data`: String,
)
