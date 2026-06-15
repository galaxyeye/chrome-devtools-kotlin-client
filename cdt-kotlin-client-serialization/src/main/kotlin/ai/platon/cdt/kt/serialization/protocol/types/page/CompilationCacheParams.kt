@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

/**
 * Per-script compilation cache parameters for `Page.produceCompilationCache`
 */
@Experimental
@Serializable
data class CompilationCacheParams(
  @SerialName("url")
  val url: String,
  @SerialName("eager")
  @param:Optional
  val eager: Boolean? = null,
)
