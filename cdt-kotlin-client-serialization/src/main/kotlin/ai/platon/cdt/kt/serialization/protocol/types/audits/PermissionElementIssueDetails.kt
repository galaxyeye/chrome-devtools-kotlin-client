@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns about improper usage of the <permission> element.
 */
@Serializable
data class PermissionElementIssueDetails(
  @property:SerialName("issueType")
  val issueType: PermissionElementIssueType,
  @property:SerialName("type")
  @param:Optional
  val type: String? = null,
  @property:SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
  @property:SerialName("isWarning")
  @param:Optional
  val isWarning: Boolean? = null,
  @property:SerialName("permissionName")
  @param:Optional
  val permissionName: String? = null,
  @property:SerialName("occluderNodeInfo")
  @param:Optional
  val occluderNodeInfo: String? = null,
  @property:SerialName("occluderParentNodeInfo")
  @param:Optional
  val occluderParentNodeInfo: String? = null,
  @property:SerialName("disableReason")
  @param:Optional
  val disableReason: String? = null,
)
