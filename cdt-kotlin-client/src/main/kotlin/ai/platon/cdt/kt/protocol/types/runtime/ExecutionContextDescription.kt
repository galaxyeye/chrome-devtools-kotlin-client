package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * Description of an isolated world.
 */
data class ExecutionContextDescription(
  @field:JsonProperty("id")
  val id: Int,
  @field:JsonProperty("origin")
  val origin: String,
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("uniqueId")
  @param:Experimental
  val uniqueId: String,
  @field:JsonProperty("auxData")
  @param:Optional
  val auxData: Map<String, Any?>? = null,
)
