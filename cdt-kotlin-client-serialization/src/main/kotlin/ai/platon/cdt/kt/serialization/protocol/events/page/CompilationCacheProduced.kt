@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued for every compilation cache generated. Is only available
 * if Page.setGenerateCompilationCache is enabled.
 */
@Serializable
@Experimental
data class CompilationCacheProduced(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("data")
  val `data`: String,
)
