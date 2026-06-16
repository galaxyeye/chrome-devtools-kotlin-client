@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Media query expression descriptor.
 */
@Serializable
data class MediaQueryExpression(
  @property:SerialName("value")
  val `value`: Double,
  @property:SerialName("unit")
  val unit: String,
  @property:SerialName("feature")
  val feature: String,
  @property:SerialName("valueRange")
  @param:Optional
  val valueRange: SourceRange? = null,
  @property:SerialName("computedLength")
  @param:Optional
  val computedLength: Double? = null,
)
