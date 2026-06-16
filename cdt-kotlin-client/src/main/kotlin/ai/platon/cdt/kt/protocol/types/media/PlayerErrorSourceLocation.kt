@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.media

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Represents logged source line numbers reported in an error.
 * NOTE: file and line are from chromium c++ implementation code, not js.
 */
data class PlayerErrorSourceLocation(
  @param:JsonProperty("file")
  val `file`: String,
  @param:JsonProperty("line")
  val line: Int,
)
