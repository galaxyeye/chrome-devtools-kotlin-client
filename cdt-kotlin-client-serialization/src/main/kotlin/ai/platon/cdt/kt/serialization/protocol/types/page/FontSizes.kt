@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int

/**
 * Default font sizes.
 */
@Experimental
@Serializable
data class FontSizes(
  @SerialName("standard")
  @param:Optional
  val standard: Int? = null,
  @SerialName("fixed")
  @param:Optional
  val fixed: Int? = null,
)
