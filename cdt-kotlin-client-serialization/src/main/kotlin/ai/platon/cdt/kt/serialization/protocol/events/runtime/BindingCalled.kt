@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notification is issued every time when binding is called.
 */
@Serializable
@Experimental
data class BindingCalled(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("payload")
  val payload: String,
  @property:SerialName("executionContextId")
  val executionContextId: Int,
)
