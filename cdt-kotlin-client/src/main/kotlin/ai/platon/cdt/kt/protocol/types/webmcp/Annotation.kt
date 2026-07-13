@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.webmcp

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Tool annotations
 */
data class Annotation(
  @param:JsonProperty("readOnly")
  @param:Optional
  val readOnly: Boolean? = null,
  @param:JsonProperty("untrustedContent")
  @param:Optional
  val untrustedContent: Boolean? = null,
  @param:JsonProperty("autosubmit")
  @param:Optional
  val autosubmit: Boolean? = null,
)
