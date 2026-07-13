@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A device bound session's inclusion rules.
 */
@Serializable
@Experimental
data class DeviceBoundSessionInclusionRules(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("includeSite")
  val includeSite: Boolean,
  @property:SerialName("urlRules")
  val urlRules: List<DeviceBoundSessionUrlRule>,
)
