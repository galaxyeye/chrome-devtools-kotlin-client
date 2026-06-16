@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Player(
  @property:SerialName("playerId")
  val playerId: String,
  @property:SerialName("domNodeId")
  @param:Optional
  val domNodeId: Int? = null,
)
