package ai.platon.cdt.kt.protocol.types.serviceworker

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * ServiceWorker error message.
 */
data class ServiceWorkerErrorMessage(
  @field:JsonProperty("errorMessage")
  val errorMessage: String,
  @field:JsonProperty("registrationId")
  val registrationId: String,
  @field:JsonProperty("versionId")
  val versionId: String,
  @field:JsonProperty("sourceURL")
  val sourceURL: String,
  @field:JsonProperty("lineNumber")
  val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  val columnNumber: Int,
)
