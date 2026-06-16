@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.LogicalAxes
import ai.platon.cdt.kt.protocol.types.dom.PhysicalAxes
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.String

/**
 * CSS container query rule descriptor.
 */
@Experimental
data class CSSContainerQuery(
  @param:JsonProperty("text")
  @Deprecated("Deprecated by protocol")
  val text: String,
  @param:JsonProperty("range")
  @param:Optional
  val range: SourceRange? = null,
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @param:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @param:JsonProperty("physicalAxes")
  @param:Optional
  val physicalAxes: PhysicalAxes? = null,
  @param:JsonProperty("logicalAxes")
  @param:Optional
  val logicalAxes: LogicalAxes? = null,
  @param:JsonProperty("queriesScrollState")
  @param:Optional
  val queriesScrollState: Boolean? = null,
  @param:JsonProperty("queriesAnchored")
  @param:Optional
  val queriesAnchored: Boolean? = null,
  @param:JsonProperty("conditionText")
  val conditionText: String,
)
