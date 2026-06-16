@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Deprecated
import kotlin.Int
import kotlin.String

/**
 * Corresponds to SpeculationRuleSet
 */
data class RuleSet(
  @param:JsonProperty("id")
  val id: String,
  @param:JsonProperty("loaderId")
  val loaderId: String,
  @param:JsonProperty("sourceText")
  val sourceText: String,
  @param:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @param:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @param:JsonProperty("requestId")
  @param:Optional
  val requestId: String? = null,
  @param:JsonProperty("errorType")
  @param:Optional
  val errorType: RuleSetErrorType? = null,
  @param:JsonProperty("errorMessage")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val errorMessage: String? = null,
  @param:JsonProperty("tag")
  @param:Optional
  val tag: String? = null,
)
