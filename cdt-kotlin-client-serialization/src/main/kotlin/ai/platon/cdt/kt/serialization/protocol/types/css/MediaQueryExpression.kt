@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String

/**
 * Media query expression descriptor.
 */
@Serializable
data class MediaQueryExpression(
  @SerialName("value")
  val `value`: Double,
  @SerialName("unit")
  val unit: String,
  @SerialName("feature")
  val feature: String,
  @SerialName("valueRange")
  @param:Optional
  val valueRange: SourceRange? = null,
  @SerialName("computedLength")
  @param:Optional
  val computedLength: Double? = null,
)
