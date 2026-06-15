@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String

/**
 * Notification is issued every time when binding is called.
 */
@Experimental
@Serializable
data class BindingCalled(
  @SerialName("name")
  val name: String,
  @SerialName("payload")
  val payload: String,
  @SerialName("executionContextId")
  val executionContextId: Int,
)
