@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.Location
import kotlin.String

/**
 * Sent when new profile recording is started using console.profile() call.
 */
@Serializable
data class ConsoleProfileStarted(
  @SerialName("id")
  val id: String,
  @SerialName("location")
  val location: Location,
  @SerialName("title")
  @param:Optional
  val title: String? = null,
)
