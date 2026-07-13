@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Deprecated
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when detached from target for any reason (including `detachFromTarget` command). Can be
 * issued multiple times per target if multiple sessions have been attached to it.
 */
@Serializable
@Experimental
data class DetachedFromTarget(
  @property:SerialName("sessionId")
  val sessionId: String,
  @property:SerialName("targetId")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val targetId: String? = null,
)
