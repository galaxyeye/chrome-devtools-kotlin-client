package ai.platon.cdt.kt.protocol.types.database

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String
import kotlin.collections.List

data class ExecuteSQL(
  @field:JsonProperty("columnNames")
  @param:Optional
  val columnNames: List<String>? = null,
  @field:JsonProperty("values")
  @param:Optional
  val values: List<Any?>? = null,
  @field:JsonProperty("sqlError")
  @param:Optional
  val sqlError: Error? = null,
)
