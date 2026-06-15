@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject

/**
 * Data entry.
 */
@Serializable
data class DataEntry(
  @SerialName("key")
  val key: RemoteObject,
  @SerialName("primaryKey")
  val primaryKey: RemoteObject,
  @SerialName("value")
  val `value`: RemoteObject,
)
