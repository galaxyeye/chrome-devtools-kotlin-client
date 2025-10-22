package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Scope description.
 */
public data class Scope(
  @field:JsonProperty("type")
  public val type: ScopeType,
  @field:JsonProperty("object")
  public val `object`: RemoteObject,
  @field:JsonProperty("name")
  @param:Optional
  public val name: String? = null,
  @field:JsonProperty("startLocation")
  @param:Optional
  public val startLocation: Location? = null,
  @field:JsonProperty("endLocation")
  @param:Optional
  public val endLocation: Location? = null,
)
