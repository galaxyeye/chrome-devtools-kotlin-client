@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Information about a cookie that is affected by an inspector issue.
 */
@Serializable
data class AffectedCookie(
  @SerialName("name")
  val name: String,
  @SerialName("path")
  val path: String,
  @SerialName("domain")
  val domain: String,
)
