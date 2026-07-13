@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The reason why Chrome uses a specific transport protocol for HTTP semantics.
 */
public enum class AlternateProtocolUsage {
  @JsonProperty("alternativeJobWonWithoutRace")
  ALTERNATIVE_JOB_WON_WITHOUT_RACE,
  @JsonProperty("alternativeJobWonRace")
  ALTERNATIVE_JOB_WON_RACE,
  @JsonProperty("mainJobWonRace")
  MAIN_JOB_WON_RACE,
  @JsonProperty("mappingMissing")
  MAPPING_MISSING,
  @JsonProperty("broken")
  BROKEN,
  @JsonProperty("dnsAlpnH3JobWonWithoutRace")
  DNS_ALPN_H_3JOB_WON_WITHOUT_RACE,
  @JsonProperty("dnsAlpnH3JobWonRace")
  DNS_ALPN_H_3JOB_WON_RACE,
  @JsonProperty("unspecifiedReason")
  UNSPECIFIED_REASON,
  @JsonEnumDefaultValue
  UNKNOWN,
}
