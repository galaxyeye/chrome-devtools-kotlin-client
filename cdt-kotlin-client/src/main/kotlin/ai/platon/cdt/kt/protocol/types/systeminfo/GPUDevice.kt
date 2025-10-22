package ai.platon.cdt.kt.protocol.types.systeminfo

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Describes a single graphics processor (GPU).
 */
data class GPUDevice(
  @field:JsonProperty("vendorId")
  val vendorId: Double,
  @field:JsonProperty("deviceId")
  val deviceId: Double,
  @field:JsonProperty("subSysId")
  @param:Optional
  val subSysId: Double? = null,
  @field:JsonProperty("revision")
  @param:Optional
  val revision: Double? = null,
  @field:JsonProperty("vendorString")
  val vendorString: String,
  @field:JsonProperty("deviceString")
  val deviceString: String,
  @field:JsonProperty("driverVendor")
  val driverVendor: String,
  @field:JsonProperty("driverVersion")
  val driverVersion: String,
)
