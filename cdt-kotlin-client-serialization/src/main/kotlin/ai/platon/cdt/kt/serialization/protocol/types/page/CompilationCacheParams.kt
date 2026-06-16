@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Per-script compilation cache parameters for `Page.produceCompilationCache`
 */
@Serializable
@Experimental
data class CompilationCacheParams(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("eager")
  @param:Optional
  val eager: Boolean? = null,
)
