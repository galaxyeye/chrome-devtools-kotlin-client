@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.AdAncestry
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The issue warns about blocked calls to privacy sensitive APIs via the
 * Selective Permissions Intervention.
 */
@Serializable
data class SelectivePermissionsInterventionIssueDetails(
  @property:SerialName("apiName")
  val apiName: String,
  @property:SerialName("adAncestry")
  val adAncestry: AdAncestry,
  @property:SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
)
