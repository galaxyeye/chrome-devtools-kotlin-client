@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.collections.List

/**
 * A subset of the full ComputedStyle as defined by the request whitelist.
 */
@Serializable
data class ComputedStyle(
  @SerialName("properties")
  val properties: List<NameValue>,
)
