@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum of shared storage access methods.
 */
public enum class SharedStorageAccessMethod {
  @JsonProperty("addModule")
  ADD_MODULE,
  @JsonProperty("createWorklet")
  CREATE_WORKLET,
  @JsonProperty("selectURL")
  SELECT_URL,
  @JsonProperty("run")
  RUN,
  @JsonProperty("batchUpdate")
  BATCH_UPDATE,
  @JsonProperty("set")
  SET,
  @JsonProperty("append")
  APPEND,
  @JsonProperty("delete")
  DELETE,
  @JsonProperty("clear")
  CLEAR,
  @JsonProperty("get")
  GET,
  @JsonProperty("keys")
  KEYS,
  @JsonProperty("values")
  VALUES,
  @JsonProperty("entries")
  ENTRIES,
  @JsonProperty("length")
  LENGTH,
  @JsonProperty("remainingBudget")
  REMAINING_BUDGET,
  @JsonEnumDefaultValue
  UNKNOWN,
}
