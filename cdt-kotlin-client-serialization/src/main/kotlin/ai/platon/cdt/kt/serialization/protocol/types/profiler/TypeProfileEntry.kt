@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.collections.List

/**
 * Source offset and types for a parameter or return value.
 */
@Experimental
@Serializable
data class TypeProfileEntry(
  @SerialName("offset")
  val offset: Int,
  @SerialName("types")
  val types: List<TypeObject>,
)
