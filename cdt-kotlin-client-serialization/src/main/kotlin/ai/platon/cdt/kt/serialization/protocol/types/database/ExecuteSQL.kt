@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.database
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.String
import kotlin.collections.List

@Serializable
data class ExecuteSQL(
  @SerialName("columnNames")
  @param:Optional
  val columnNames: List<String>? = null,
  @SerialName("values")
  @param:Optional
  val values: List<Any?>? = null,
  @SerialName("sqlError")
  @param:Optional
  val sqlError: Error? = null,
)
