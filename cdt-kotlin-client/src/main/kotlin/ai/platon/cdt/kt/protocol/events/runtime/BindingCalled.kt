package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Notification is issued every time when binding is called.
 */
@Experimental
data class BindingCalled(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("payload")
  val payload: String,
  @field:JsonProperty("executionContextId")
  val executionContextId: Int,
)
