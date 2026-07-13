@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Represents the provenance of an ad resource or element. Only one of
 * `filterlistRule` or `adScriptAncestry` can be set. If `filterlistRule`
 * is provided, the resource URL directly matches a filter list rule. If
 * `adScriptAncestry` is provided, an ad script initiated the resource fetch or
 * appended the element to the DOM. If neither is provided, the entity is
 * known to be an ad, but provenance tracking information is unavailable.
 */
@Experimental
data class AdProvenance(
  @param:JsonProperty("filterlistRule")
  @param:Optional
  val filterlistRule: String? = null,
  @param:JsonProperty("adScriptAncestry")
  @param:Optional
  val adScriptAncestry: AdAncestry? = null,
)
