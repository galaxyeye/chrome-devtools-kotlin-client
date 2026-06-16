@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.database

import ai.platon.cdt.kt.serialization.protocol.types.database.Database
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddDatabase(
  @property:SerialName("database")
  val database: Database,
)
