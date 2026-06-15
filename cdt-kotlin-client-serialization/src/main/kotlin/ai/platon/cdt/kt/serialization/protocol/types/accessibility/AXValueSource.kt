@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

/**
 * A single source for a computed AX property.
 */
@Serializable
data class AXValueSource(
  @SerialName("type")
  val type: AXValueSourceType,
  @SerialName("value")
  @param:Optional
  val `value`: AXValue? = null,
  @SerialName("attribute")
  @param:Optional
  val attribute: String? = null,
  @SerialName("attributeValue")
  @param:Optional
  val attributeValue: AXValue? = null,
  @SerialName("superseded")
  @param:Optional
  val superseded: Boolean? = null,
  @SerialName("nativeSource")
  @param:Optional
  val nativeSource: AXValueNativeSourceType? = null,
  @SerialName("nativeSourceValue")
  @param:Optional
  val nativeSourceValue: AXValue? = null,
  @SerialName("invalid")
  @param:Optional
  val invalid: Boolean? = null,
  @SerialName("invalidReason")
  @param:Optional
  val invalidReason: String? = null,
)
