@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ScopeExtension(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("hasOriginWildcard")
  val hasOriginWildcard: Boolean,
)
