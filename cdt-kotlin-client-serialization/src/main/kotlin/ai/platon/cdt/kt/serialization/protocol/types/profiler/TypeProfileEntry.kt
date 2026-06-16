@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Source offset and types for a parameter or return value.
 */
@Serializable
@Experimental
data class TypeProfileEntry(
  @property:SerialName("offset")
  val offset: Int,
  @property:SerialName("types")
  val types: List<TypeObject>,
)
