package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Debug symbols available for a wasm script.
 */
public data class DebugSymbols(
  @field:JsonProperty("type")
  public val type: DebugSymbolsType,
  @field:JsonProperty("externalURL")
  @param:Optional
  public val externalURL: String? = null,
)
