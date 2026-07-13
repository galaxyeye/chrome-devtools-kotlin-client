@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS generic @rule representation.
 */
@Serializable
data class CSSAtRule(
  @property:SerialName("type")
  val type: CSSAtRuleType,
  @property:SerialName("subsection")
  @param:Optional
  val subsection: CSSAtRuleSubsection? = null,
  @property:SerialName("name")
  @param:Optional
  val name: Value? = null,
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("style")
  val style: CSSStyle,
)
