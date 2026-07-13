@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of shared storage access methods.
 */
@Serializable
public enum class SharedStorageAccessMethod {
  @SerialName("addModule")
  ADD_MODULE,
  @SerialName("createWorklet")
  CREATE_WORKLET,
  @SerialName("selectURL")
  SELECT_URL,
  @SerialName("run")
  RUN,
  @SerialName("batchUpdate")
  BATCH_UPDATE,
  @SerialName("set")
  SET,
  @SerialName("append")
  APPEND,
  @SerialName("delete")
  DELETE,
  @SerialName("clear")
  CLEAR,
  @SerialName("get")
  GET,
  @SerialName("keys")
  KEYS,
  @SerialName("values")
  VALUES,
  @SerialName("entries")
  ENTRIES,
  @SerialName("length")
  LENGTH,
  @SerialName("remainingBudget")
  REMAINING_BUDGET,
  UNKNOWN,
}
