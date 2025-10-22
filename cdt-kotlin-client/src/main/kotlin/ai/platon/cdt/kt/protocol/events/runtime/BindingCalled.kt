package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Notification is issued every time when binding is called.
 */
@Experimental
public data class BindingCalled(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("payload")
  public val payload: String,
  @field:JsonProperty("executionContextId")
  public val executionContextId: Int,
)
