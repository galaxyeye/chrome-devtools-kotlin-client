@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

/**
 * Violation configuration setting.
 */
@Serializable
data class ViolationSetting(
  @SerialName("name")
  val name: ViolationSettingName,
  @SerialName("threshold")
  val threshold: Double,
)
