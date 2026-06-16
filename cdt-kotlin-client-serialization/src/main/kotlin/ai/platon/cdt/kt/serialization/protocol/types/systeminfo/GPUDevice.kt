@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes a single graphics processor (GPU).
 */
@Serializable
data class GPUDevice(
  @property:SerialName("vendorId")
  val vendorId: Double,
  @property:SerialName("deviceId")
  val deviceId: Double,
  @property:SerialName("subSysId")
  @param:Optional
  val subSysId: Double? = null,
  @property:SerialName("revision")
  @param:Optional
  val revision: Double? = null,
  @property:SerialName("vendorString")
  val vendorString: String,
  @property:SerialName("deviceString")
  val deviceString: String,
  @property:SerialName("driverVendor")
  val driverVendor: String,
  @property:SerialName("driverVersion")
  val driverVersion: String,
)
