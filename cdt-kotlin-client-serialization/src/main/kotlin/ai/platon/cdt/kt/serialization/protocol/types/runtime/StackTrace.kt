@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Call frames for assertions or error messages.
 */
@Serializable
data class StackTrace(
  @property:SerialName("description")
  @param:Optional
  val description: String? = null,
  @property:SerialName("callFrames")
  val callFrames: List<CallFrame>,
  @property:SerialName("parent")
  @param:Optional
  val parent: StackTrace? = null,
  @property:SerialName("parentId")
  @param:Optional
  @param:Experimental
  val parentId: StackTraceId? = null,
)
