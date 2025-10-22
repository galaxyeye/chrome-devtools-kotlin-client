package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Scope description.
 */
data class Scope(
  @field:JsonProperty("type")
  val type: ScopeType,
  @field:JsonProperty("object")
  val `object`: RemoteObject,
  @field:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @field:JsonProperty("startLocation")
  @param:Optional
  val startLocation: Location? = null,
  @field:JsonProperty("endLocation")
  @param:Optional
  val endLocation: Location? = null,
)
