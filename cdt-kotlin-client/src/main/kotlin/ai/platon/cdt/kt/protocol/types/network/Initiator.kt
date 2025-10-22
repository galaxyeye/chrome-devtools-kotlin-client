package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Information about the request initiator.
 */
public data class Initiator(
  @field:JsonProperty("type")
  public val type: InitiatorType,
  @field:JsonProperty("stack")
  @param:Optional
  public val stack: StackTrace? = null,
  @field:JsonProperty("url")
  @param:Optional
  public val url: String? = null,
  @field:JsonProperty("lineNumber")
  @param:Optional
  public val lineNumber: Double? = null,
  @field:JsonProperty("columnNumber")
  @param:Optional
  public val columnNumber: Double? = null,
  @field:JsonProperty("requestId")
  @param:Optional
  public val requestId: String? = null,
)
