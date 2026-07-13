@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Deprecated
import kotlin.String

@Deprecated("Deprecated")
data class NavigatorUserAgentIssueDetails(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("location")
  @param:Optional
  val location: SourceCodeLocation? = null,
)
