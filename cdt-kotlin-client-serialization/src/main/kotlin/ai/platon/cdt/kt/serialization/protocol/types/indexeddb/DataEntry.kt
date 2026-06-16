@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data entry.
 */
@Serializable
data class DataEntry(
  @property:SerialName("key")
  val key: RemoteObject,
  @property:SerialName("primaryKey")
  val primaryKey: RemoteObject,
  @property:SerialName("value")
  val `value`: RemoteObject,
)
