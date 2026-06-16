@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type profile data collected during runtime for a JavaScript script.
 */
@Serializable
@Experimental
data class ScriptTypeProfile(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("entries")
  val entries: List<TypeProfileEntry>,
)
