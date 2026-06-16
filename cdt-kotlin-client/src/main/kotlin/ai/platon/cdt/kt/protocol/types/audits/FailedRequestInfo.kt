@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class FailedRequestInfo(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("failureMessage")
  val failureMessage: String,
  @param:JsonProperty("requestId")
  @param:Optional
  val requestId: String? = null,
)
