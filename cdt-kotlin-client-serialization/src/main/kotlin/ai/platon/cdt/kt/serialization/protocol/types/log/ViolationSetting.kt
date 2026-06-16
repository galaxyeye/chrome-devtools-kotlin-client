@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Violation configuration setting.
 */
@Serializable
data class ViolationSetting(
  @property:SerialName("name")
  val name: ViolationSettingName,
  @property:SerialName("threshold")
  val threshold: Double,
)
