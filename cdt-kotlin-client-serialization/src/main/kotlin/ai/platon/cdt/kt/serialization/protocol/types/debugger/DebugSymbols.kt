@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Debug symbols available for a wasm script.
 */
@Serializable
data class DebugSymbols(
  @property:SerialName("type")
  val type: DebugSymbolsType,
  @property:SerialName("externalURL")
  @param:Optional
  val externalURL: String? = null,
)
