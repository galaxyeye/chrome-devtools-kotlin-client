@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.database

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Database object.
 */
@Serializable
data class Database(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("domain")
  val domain: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("version")
  val version: String,
)
