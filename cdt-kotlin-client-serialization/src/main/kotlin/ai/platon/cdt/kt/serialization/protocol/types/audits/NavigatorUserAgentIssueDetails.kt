@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Deprecated
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Deprecated("Deprecated")
data class NavigatorUserAgentIssueDetails(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("location")
  @param:Optional
  val location: SourceCodeLocation? = null,
)
