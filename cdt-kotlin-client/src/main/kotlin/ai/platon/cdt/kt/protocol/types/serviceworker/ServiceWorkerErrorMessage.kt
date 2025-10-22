package ai.platon.cdt.kt.protocol.types.serviceworker

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * ServiceWorker error message.
 */
public data class ServiceWorkerErrorMessage(
  @field:JsonProperty("errorMessage")
  public val errorMessage: String,
  @field:JsonProperty("registrationId")
  public val registrationId: String,
  @field:JsonProperty("versionId")
  public val versionId: String,
  @field:JsonProperty("sourceURL")
  public val sourceURL: String,
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  public val columnNumber: Int,
)
