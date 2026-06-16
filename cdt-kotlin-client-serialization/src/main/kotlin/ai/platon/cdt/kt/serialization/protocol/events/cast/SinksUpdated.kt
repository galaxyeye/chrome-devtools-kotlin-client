@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.cast

import ai.platon.cdt.kt.serialization.protocol.types.cast.Sink
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This is fired whenever the list of available sinks changes. A sink is a
 * device or a software surface that you can cast to.
 */
@Serializable
data class SinksUpdated(
  @property:SerialName("sinks")
  val sinks: List<Sink>,
)
