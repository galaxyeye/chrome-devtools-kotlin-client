@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.LogicalAxes
import ai.platon.cdt.kt.serialization.protocol.types.dom.PhysicalAxes
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS container query rule descriptor.
 */
@Serializable
@Experimental
data class CSSContainerQuery(
  @property:SerialName("text")
  @Deprecated("Deprecated by protocol")
  val text: String,
  @property:SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("physicalAxes")
  @param:Optional
  val physicalAxes: PhysicalAxes? = null,
  @property:SerialName("logicalAxes")
  @param:Optional
  val logicalAxes: LogicalAxes? = null,
  @property:SerialName("queriesScrollState")
  @param:Optional
  val queriesScrollState: Boolean? = null,
  @property:SerialName("queriesAnchored")
  @param:Optional
  val queriesAnchored: Boolean? = null,
  @property:SerialName("conditionText")
  val conditionText: String,
)
