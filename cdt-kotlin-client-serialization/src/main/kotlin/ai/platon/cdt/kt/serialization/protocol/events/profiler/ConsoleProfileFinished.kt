@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.debugger.Location
import ai.platon.cdt.kt.serialization.protocol.types.profiler.Profile
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConsoleProfileFinished(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("location")
  val location: Location,
  @property:SerialName("profile")
  val profile: Profile,
  @property:SerialName("title")
  @param:Optional
  val title: String? = null,
)
