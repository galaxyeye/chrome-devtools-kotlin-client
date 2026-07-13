@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents logged source line numbers reported in an error.
 * NOTE: file and line are from chromium c++ implementation code, not js.
 */
@Serializable
data class PlayerErrorSourceLocation(
  @property:SerialName("file")
  val `file`: String,
  @property:SerialName("line")
  val line: Int,
)
