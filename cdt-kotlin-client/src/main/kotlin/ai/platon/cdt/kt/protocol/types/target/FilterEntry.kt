@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.target

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * A filter used by target query/discovery/auto-attach operations.
 */
@Experimental
data class FilterEntry(
  @param:JsonProperty("exclude")
  @param:Optional
  val exclude: Boolean? = null,
  @param:JsonProperty("type")
  @param:Optional
  val type: String? = null,
)
