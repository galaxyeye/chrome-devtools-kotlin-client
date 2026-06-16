@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Default font sizes.
 */
@Serializable
@Experimental
data class FontSizes(
  @property:SerialName("standard")
  @param:Optional
  val standard: Int? = null,
  @property:SerialName("fixed")
  @param:Optional
  val fixed: Int? = null,
)
