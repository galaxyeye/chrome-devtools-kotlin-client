@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class PermissionsPolicyBlockLocator(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("blockReason")
  val blockReason: PermissionsPolicyBlockReason,
)
