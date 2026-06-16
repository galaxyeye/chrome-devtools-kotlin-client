@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes a type collected during runtime.
 */
@Serializable
@Experimental
data class TypeObject(
  @property:SerialName("name")
  val name: String,
)
