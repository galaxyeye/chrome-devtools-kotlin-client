@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.database
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Database error.
 */
@Serializable
data class Error(
  @SerialName("message")
  val message: String,
  @SerialName("code")
  val code: Int,
)
