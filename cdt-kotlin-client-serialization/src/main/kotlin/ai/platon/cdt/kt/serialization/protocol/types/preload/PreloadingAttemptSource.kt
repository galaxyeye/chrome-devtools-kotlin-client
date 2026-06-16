@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Lists sources for a preloading attempt, specifically the ids of rule sets
 * that had a speculation rule that triggered the attempt, and the
 * BackendNodeIds of <a href> or <area href> elements that triggered the
 * attempt (in the case of attempts triggered by a document rule). It is
 * possible for multiple rule sets and links to trigger a single attempt.
 */
@Serializable
data class PreloadingAttemptSource(
  @property:SerialName("key")
  val key: PreloadingAttemptKey,
  @property:SerialName("ruleSetIds")
  val ruleSetIds: List<String>,
  @property:SerialName("nodeIds")
  val nodeIds: List<Int>,
)
