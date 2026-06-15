@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cast
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Serializable
data class Sink(
  @SerialName("name")
  val name: String,
  @SerialName("id")
  val id: String,
  @SerialName("session")
  @param:Optional
  val session: String? = null,
)
