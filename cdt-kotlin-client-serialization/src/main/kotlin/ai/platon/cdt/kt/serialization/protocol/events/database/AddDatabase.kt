@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.database
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.database.Database

@Serializable
data class AddDatabase(
  @SerialName("database")
  val database: Database,
)
