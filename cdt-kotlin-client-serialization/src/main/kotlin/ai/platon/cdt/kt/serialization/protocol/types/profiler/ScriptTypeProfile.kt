@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlin.collections.List

/**
 * Type profile data collected during runtime for a JavaScript script.
 */
@Experimental
@Serializable
data class ScriptTypeProfile(
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("url")
  val url: String,
  @SerialName("entries")
  val entries: List<TypeProfileEntry>,
)
