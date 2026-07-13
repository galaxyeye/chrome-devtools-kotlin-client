@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when a target has crashed.
 */
@Serializable
data class TargetCrashed(
  @property:SerialName("targetId")
  val targetId: String,
  @property:SerialName("status")
  val status: String,
  @property:SerialName("errorCode")
  val errorCode: Int,
)
