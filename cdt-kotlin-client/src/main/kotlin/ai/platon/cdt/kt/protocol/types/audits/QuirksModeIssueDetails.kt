@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * Details for issues about documents in Quirks Mode
 * or Limited Quirks Mode that affects page layouting.
 */
data class QuirksModeIssueDetails(
  @param:JsonProperty("isLimitedQuirksMode")
  val isLimitedQuirksMode: Boolean,
  @param:JsonProperty("documentNodeId")
  val documentNodeId: Int,
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("loaderId")
  val loaderId: String,
)
