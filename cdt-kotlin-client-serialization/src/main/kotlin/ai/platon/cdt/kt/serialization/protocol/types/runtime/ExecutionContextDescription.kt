@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Description of an isolated world.
 */
@Serializable
data class ExecutionContextDescription(
  @property:SerialName("id")
  val id: Int,
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("uniqueId")
  @param:Experimental
  val uniqueId: String,
  @property:SerialName("auxData")
  @param:Optional
  val auxData: JsonObject? = null,
)
