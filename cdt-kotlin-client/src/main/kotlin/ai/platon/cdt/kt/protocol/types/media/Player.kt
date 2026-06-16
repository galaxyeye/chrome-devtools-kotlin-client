@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.media

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class Player(
  @param:JsonProperty("playerId")
  val playerId: String,
  @param:JsonProperty("domNodeId")
  @param:Optional
  val domNodeId: Int? = null,
)
