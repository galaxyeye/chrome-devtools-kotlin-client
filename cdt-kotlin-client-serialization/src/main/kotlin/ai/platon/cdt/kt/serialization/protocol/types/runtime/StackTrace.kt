@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Call frames for assertions or error messages.
 */
@Serializable
data class StackTrace(
  @SerialName("description")
  @param:Optional
  val description: String? = null,
  @SerialName("callFrames")
  val callFrames: List<CallFrame>,
  @SerialName("parent")
  @param:Optional
  val parent: StackTrace? = null,
  @SerialName("parentId")
  @param:Optional
  @param:Experimental
  val parentId: StackTraceId? = null,
)
