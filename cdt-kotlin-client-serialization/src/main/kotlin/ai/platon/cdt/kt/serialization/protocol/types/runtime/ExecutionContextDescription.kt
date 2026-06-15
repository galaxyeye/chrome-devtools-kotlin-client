@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Description of an isolated world.
 */
@Serializable
data class ExecutionContextDescription(
  @SerialName("id")
  val id: Int,
  @SerialName("origin")
  val origin: String,
  @SerialName("name")
  val name: String,
  @SerialName("uniqueId")
  @param:Experimental
  val uniqueId: String,
  @SerialName("auxData")
  @param:Optional
  val auxData: Map<String, Any?>? = null,
)
