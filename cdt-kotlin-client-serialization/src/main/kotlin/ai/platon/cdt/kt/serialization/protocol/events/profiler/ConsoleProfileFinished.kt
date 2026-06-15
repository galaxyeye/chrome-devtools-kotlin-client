@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.Location
import ai.platon.cdt.kt.serialization.protocol.types.profiler.Profile
import kotlin.String

@Serializable
data class ConsoleProfileFinished(
  @SerialName("id")
  val id: String,
  @SerialName("location")
  val location: Location,
  @SerialName("profile")
  val profile: Profile,
  @SerialName("title")
  @param:Optional
  val title: String? = null,
)
