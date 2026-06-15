@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String

/**
 * Describes a single graphics processor (GPU).
 */
@Serializable
data class GPUDevice(
  @SerialName("vendorId")
  val vendorId: Double,
  @SerialName("deviceId")
  val deviceId: Double,
  @SerialName("subSysId")
  @param:Optional
  val subSysId: Double? = null,
  @SerialName("revision")
  @param:Optional
  val revision: Double? = null,
  @SerialName("vendorString")
  val vendorString: String,
  @SerialName("deviceString")
  val deviceString: String,
  @SerialName("driverVendor")
  val driverVendor: String,
  @SerialName("driverVersion")
  val driverVersion: String,
)
