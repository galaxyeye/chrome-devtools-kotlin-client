@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The reason why Chrome uses a specific transport protocol for HTTP semantics.
 */
@Serializable
public enum class AlternateProtocolUsage {
  @SerialName("alternativeJobWonWithoutRace")
  ALTERNATIVE_JOB_WON_WITHOUT_RACE,
  @SerialName("alternativeJobWonRace")
  ALTERNATIVE_JOB_WON_RACE,
  @SerialName("mainJobWonRace")
  MAIN_JOB_WON_RACE,
  @SerialName("mappingMissing")
  MAPPING_MISSING,
  @SerialName("broken")
  BROKEN,
  @SerialName("dnsAlpnH3JobWonWithoutRace")
  DNS_ALPN_H_3JOB_WON_WITHOUT_RACE,
  @SerialName("dnsAlpnH3JobWonRace")
  DNS_ALPN_H_3JOB_WON_RACE,
  @SerialName("unspecifiedReason")
  UNSPECIFIED_REASON,
  UNKNOWN,
}
