@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * This issue warns about improper usage of the <permission> element.
 */
data class PermissionElementIssueDetails(
  @param:JsonProperty("issueType")
  val issueType: PermissionElementIssueType,
  @param:JsonProperty("type")
  @param:Optional
  val type: String? = null,
  @param:JsonProperty("nodeId")
  @param:Optional
  val nodeId: Int? = null,
  @param:JsonProperty("isWarning")
  @param:Optional
  val isWarning: Boolean? = null,
  @param:JsonProperty("permissionName")
  @param:Optional
  val permissionName: String? = null,
  @param:JsonProperty("occluderNodeInfo")
  @param:Optional
  val occluderNodeInfo: String? = null,
  @param:JsonProperty("occluderParentNodeInfo")
  @param:Optional
  val occluderParentNodeInfo: String? = null,
  @param:JsonProperty("disableReason")
  @param:Optional
  val disableReason: String? = null,
)
