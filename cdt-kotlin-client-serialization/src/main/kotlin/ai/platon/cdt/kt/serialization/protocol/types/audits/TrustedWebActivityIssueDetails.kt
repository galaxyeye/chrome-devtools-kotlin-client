@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

@Serializable
data class TrustedWebActivityIssueDetails(
  @SerialName("url")
  val url: String,
  @SerialName("violationType")
  val violationType: TwaQualityEnforcementViolationType,
  @SerialName("httpStatusCode")
  @param:Optional
  val httpStatusCode: Int? = null,
  @SerialName("packageName")
  @param:Optional
  val packageName: String? = null,
  @SerialName("signature")
  @param:Optional
  val signature: String? = null,
)
