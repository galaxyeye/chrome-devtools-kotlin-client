@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.cast
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * This is fired whenever the outstanding issue/error message changes.
 * |issueMessage| is empty if there is no issue.
 */
@Serializable
data class IssueUpdated(
  @SerialName("issueMessage")
  val issueMessage: String,
)
