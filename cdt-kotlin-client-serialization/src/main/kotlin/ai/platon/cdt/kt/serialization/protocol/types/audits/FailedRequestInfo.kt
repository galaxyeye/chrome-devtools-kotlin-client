@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FailedRequestInfo(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("failureMessage")
  val failureMessage: String,
  @property:SerialName("requestId")
  @param:Optional
  val requestId: String? = null,
)
