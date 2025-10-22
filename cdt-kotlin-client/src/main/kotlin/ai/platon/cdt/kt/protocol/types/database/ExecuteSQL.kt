package ai.platon.cdt.kt.protocol.types.database

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String
import kotlin.collections.List

public data class ExecuteSQL(
  @field:JsonProperty("columnNames")
  @param:Optional
  public val columnNames: List<String>? = null,
  @field:JsonProperty("values")
  @param:Optional
  public val values: List<Any?>? = null,
  @field:JsonProperty("sqlError")
  @param:Optional
  public val sqlError: Error? = null,
)
