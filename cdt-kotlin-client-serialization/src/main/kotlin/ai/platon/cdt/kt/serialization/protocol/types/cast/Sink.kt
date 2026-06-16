@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cast

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sink(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("id")
  val id: String,
  @property:SerialName("session")
  @param:Optional
  val session: String? = null,
)
