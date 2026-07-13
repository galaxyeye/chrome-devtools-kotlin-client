@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import ai.platon.cdt.kt.serialization.protocol.types.target.TargetInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when a possible inspection target is created.
 */
@Serializable
data class TargetCreated(
  @property:SerialName("targetInfo")
  val targetInfo: TargetInfo,
)
