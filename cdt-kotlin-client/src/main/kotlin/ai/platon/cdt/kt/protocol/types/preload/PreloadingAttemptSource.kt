@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Lists sources for a preloading attempt, specifically the ids of rule sets
 * that had a speculation rule that triggered the attempt, and the
 * BackendNodeIds of <a href> or <area href> elements that triggered the
 * attempt (in the case of attempts triggered by a document rule). It is
 * possible for multiple rule sets and links to trigger a single attempt.
 */
data class PreloadingAttemptSource(
  @param:JsonProperty("key")
  val key: PreloadingAttemptKey,
  @param:JsonProperty("ruleSetIds")
  val ruleSetIds: List<String>,
  @param:JsonProperty("nodeIds")
  val nodeIds: List<Int>,
)
