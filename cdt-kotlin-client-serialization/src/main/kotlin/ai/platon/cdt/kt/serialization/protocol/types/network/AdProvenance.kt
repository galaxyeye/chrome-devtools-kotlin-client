@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the provenance of an ad resource or element. Only one of
 * `filterlistRule` or `adScriptAncestry` can be set. If `filterlistRule`
 * is provided, the resource URL directly matches a filter list rule. If
 * `adScriptAncestry` is provided, an ad script initiated the resource fetch or
 * appended the element to the DOM. If neither is provided, the entity is
 * known to be an ad, but provenance tracking information is unavailable.
 */
@Serializable
@Experimental
data class AdProvenance(
  @property:SerialName("filterlistRule")
  @param:Optional
  val filterlistRule: String? = null,
  @property:SerialName("adScriptAncestry")
  @param:Optional
  val adScriptAncestry: AdAncestry? = null,
)
