@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.database

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Database error.
 */
@Serializable
data class Error(
  @property:SerialName("message")
  val message: String,
  @property:SerialName("code")
  val code: Int,
)
