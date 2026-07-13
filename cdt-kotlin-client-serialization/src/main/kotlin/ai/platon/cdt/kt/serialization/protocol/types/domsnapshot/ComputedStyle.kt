@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A subset of the full ComputedStyle as defined by the request whitelist.
 */
@Serializable
data class ComputedStyle(
  @property:SerialName("properties")
  val properties: List<NameValue>,
)
