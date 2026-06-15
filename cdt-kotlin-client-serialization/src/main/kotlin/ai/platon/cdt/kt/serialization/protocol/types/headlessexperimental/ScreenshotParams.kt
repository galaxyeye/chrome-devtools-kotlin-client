@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.headlessexperimental
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int

/**
 * Encoding options for a screenshot.
 */
@Serializable
data class ScreenshotParams(
  @SerialName("format")
  @param:Optional
  val format: ScreenshotParamsFormat? = null,
  @SerialName("quality")
  @param:Optional
  val quality: Int? = null,
)
