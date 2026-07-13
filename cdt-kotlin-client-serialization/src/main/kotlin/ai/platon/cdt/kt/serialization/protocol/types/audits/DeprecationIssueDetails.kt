@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue tracks information needed to print a deprecation message.
 * https://source.chromium.org/chromium/chromium/src/+/main:third_party/blink/renderer/core/frame/third_party/blink/renderer/core/frame/deprecation/README.md
 */
@Serializable
data class DeprecationIssueDetails(
  @property:SerialName("affectedFrame")
  @param:Optional
  val affectedFrame: AffectedFrame? = null,
  @property:SerialName("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @property:SerialName("type")
  val type: String,
)
