package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Information about the request initiator.
 */
data class Initiator(
  @field:JsonProperty("type")
  val type: InitiatorType,
  @field:JsonProperty("stack")
  @param:Optional
  val stack: StackTrace? = null,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @field:JsonProperty("lineNumber")
  @param:Optional
  val lineNumber: Double? = null,
  @field:JsonProperty("columnNumber")
  @param:Optional
  val columnNumber: Double? = null,
  @field:JsonProperty("requestId")
  @param:Optional
  val requestId: String? = null,
)
