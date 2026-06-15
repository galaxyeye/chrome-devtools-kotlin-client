@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Debug symbols available for a wasm script.
 */
@Serializable
data class DebugSymbols(
  @SerialName("type")
  val type: DebugSymbolsType,
  @SerialName("externalURL")
  @param:Optional
  val externalURL: String? = null,
)
