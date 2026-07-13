@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * This issue tracks information needed to print a deprecation message.
 * https://source.chromium.org/chromium/chromium/src/+/main:third_party/blink/renderer/core/frame/third_party/blink/renderer/core/frame/deprecation/README.md
 */
data class DeprecationIssueDetails(
  @param:JsonProperty("affectedFrame")
  @param:Optional
  val affectedFrame: AffectedFrame? = null,
  @param:JsonProperty("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @param:JsonProperty("type")
  val type: String,
)
