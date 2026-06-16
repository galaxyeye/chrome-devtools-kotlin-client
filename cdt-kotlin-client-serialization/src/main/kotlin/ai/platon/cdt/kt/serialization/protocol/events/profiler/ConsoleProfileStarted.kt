@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.Location
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sent when new profile recording is started using console.profile() call.
 */
@Serializable
data class ConsoleProfileStarted(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("location")
  val location: Location,
  @property:SerialName("title")
  @param:Optional
  val title: String? = null,
)
