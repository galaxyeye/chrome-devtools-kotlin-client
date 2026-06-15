@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.database
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Database object.
 */
@Serializable
data class Database(
  @SerialName("id")
  val id: String,
  @SerialName("domain")
  val domain: String,
  @SerialName("name")
  val name: String,
  @SerialName("version")
  val version: String,
)
