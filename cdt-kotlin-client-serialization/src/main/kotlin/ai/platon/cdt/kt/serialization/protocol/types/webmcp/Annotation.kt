@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webmcp

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Tool annotations
 */
@Serializable
data class Annotation(
  @property:SerialName("readOnly")
  @param:Optional
  val readOnly: Boolean? = null,
  @property:SerialName("untrustedContent")
  @param:Optional
  val untrustedContent: Boolean? = null,
  @property:SerialName("autosubmit")
  @param:Optional
  val autosubmit: Boolean? = null,
)
