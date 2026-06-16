@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrustedWebActivityIssueDetails(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("violationType")
  val violationType: TwaQualityEnforcementViolationType,
  @property:SerialName("httpStatusCode")
  @param:Optional
  val httpStatusCode: Int? = null,
  @property:SerialName("packageName")
  @param:Optional
  val packageName: String? = null,
  @property:SerialName("signature")
  @param:Optional
  val signature: String? = null,
)
