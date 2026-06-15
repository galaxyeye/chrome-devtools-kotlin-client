@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Describes a type collected during runtime.
 */
@Experimental
@Serializable
data class TypeObject(
  @SerialName("name")
  val name: String,
)
