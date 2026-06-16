@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.accessibility

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A single source for a computed AX property.
 */
@Serializable
data class AXValueSource(
  @property:SerialName("type")
  val type: AXValueSourceType,
  @property:SerialName("value")
  @param:Optional
  val `value`: AXValue? = null,
  @property:SerialName("attribute")
  @param:Optional
  val attribute: String? = null,
  @property:SerialName("attributeValue")
  @param:Optional
  val attributeValue: AXValue? = null,
  @property:SerialName("superseded")
  @param:Optional
  val superseded: Boolean? = null,
  @property:SerialName("nativeSource")
  @param:Optional
  val nativeSource: AXValueNativeSourceType? = null,
  @property:SerialName("nativeSourceValue")
  @param:Optional
  val nativeSourceValue: AXValue? = null,
  @property:SerialName("invalid")
  @param:Optional
  val invalid: Boolean? = null,
  @property:SerialName("invalidReason")
  @param:Optional
  val invalidReason: String? = null,
)
