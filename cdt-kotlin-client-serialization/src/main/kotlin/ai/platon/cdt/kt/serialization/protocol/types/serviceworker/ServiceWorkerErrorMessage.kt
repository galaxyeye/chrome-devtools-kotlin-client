@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ServiceWorker error message.
 */
@Serializable
data class ServiceWorkerErrorMessage(
  @property:SerialName("errorMessage")
  val errorMessage: String,
  @property:SerialName("registrationId")
  val registrationId: String,
  @property:SerialName("versionId")
  val versionId: String,
  @property:SerialName("sourceURL")
  val sourceURL: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
)
