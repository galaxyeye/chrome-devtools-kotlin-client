@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * ServiceWorker error message.
 */
@Serializable
data class ServiceWorkerErrorMessage(
  @SerialName("errorMessage")
  val errorMessage: String,
  @SerialName("registrationId")
  val registrationId: String,
  @SerialName("versionId")
  val versionId: String,
  @SerialName("sourceURL")
  val sourceURL: String,
  @SerialName("lineNumber")
  val lineNumber: Int,
  @SerialName("columnNumber")
  val columnNumber: Int,
)
