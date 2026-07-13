@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A filter used by target query/discovery/auto-attach operations.
 */
@Serializable
@Experimental
data class FilterEntry(
  @property:SerialName("exclude")
  @param:Optional
  val exclude: Boolean? = null,
  @property:SerialName("type")
  @param:Optional
  val type: String? = null,
)
