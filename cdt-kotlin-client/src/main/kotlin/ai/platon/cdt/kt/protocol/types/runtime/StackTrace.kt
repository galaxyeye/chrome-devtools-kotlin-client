package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Call frames for assertions or error messages.
 */
public data class StackTrace(
  @field:JsonProperty("description")
  @param:Optional
  public val description: String? = null,
  @field:JsonProperty("callFrames")
  public val callFrames: List<CallFrame>,
  @field:JsonProperty("parent")
  @param:Optional
  public val parent: StackTrace? = null,
  @field:JsonProperty("parentId")
  @param:Optional
  @param:Experimental
  public val parentId: StackTraceId? = null,
)
