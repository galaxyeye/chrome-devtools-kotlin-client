@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.headlessexperimental

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Encoding options for a screenshot.
 */
@Serializable
data class ScreenshotParams(
  @property:SerialName("format")
  @param:Optional
  val format: ScreenshotParamsFormat? = null,
  @property:SerialName("quality")
  @param:Optional
  val quality: Int? = null,
)
