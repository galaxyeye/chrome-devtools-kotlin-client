@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.AdAncestry
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * The issue warns about blocked calls to privacy sensitive APIs via the
 * Selective Permissions Intervention.
 */
data class SelectivePermissionsInterventionIssueDetails(
  @param:JsonProperty("apiName")
  val apiName: String,
  @param:JsonProperty("adAncestry")
  val adAncestry: AdAncestry,
  @param:JsonProperty("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
)
