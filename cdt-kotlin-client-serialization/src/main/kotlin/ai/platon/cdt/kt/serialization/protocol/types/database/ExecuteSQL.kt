@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.database

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ExecuteSQL(
  @property:SerialName("columnNames")
  @param:Optional
  val columnNames: List<String>? = null,
  @property:SerialName("values")
  @param:Optional
  val values: List<JsonElement?>? = null,
  @property:SerialName("sqlError")
  @param:Optional
  val sqlError: Error? = null,
)
