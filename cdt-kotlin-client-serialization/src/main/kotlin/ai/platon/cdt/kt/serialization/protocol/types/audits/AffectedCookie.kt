@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a cookie that is affected by an inspector issue.
 */
@Serializable
data class AffectedCookie(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("path")
  val path: String,
  @property:SerialName("domain")
  val domain: String,
)
