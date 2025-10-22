package ai.platon.cdt.kt.protocol.types.systeminfo

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Describes a single graphics processor (GPU).
 */
public data class GPUDevice(
  @field:JsonProperty("vendorId")
  public val vendorId: Double,
  @field:JsonProperty("deviceId")
  public val deviceId: Double,
  @field:JsonProperty("subSysId")
  @param:Optional
  public val subSysId: Double? = null,
  @field:JsonProperty("revision")
  @param:Optional
  public val revision: Double? = null,
  @field:JsonProperty("vendorString")
  public val vendorString: String,
  @field:JsonProperty("deviceString")
  public val deviceString: String,
  @field:JsonProperty("driverVendor")
  public val driverVendor: String,
  @field:JsonProperty("driverVersion")
  public val driverVersion: String,
)
