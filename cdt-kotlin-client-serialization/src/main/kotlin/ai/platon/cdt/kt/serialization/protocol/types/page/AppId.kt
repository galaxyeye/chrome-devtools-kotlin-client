@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppId(
  @property:SerialName("appId")
  @param:Optional
  val appId: String? = null,
  @property:SerialName("recommendedId")
  @param:Optional
  val recommendedId: String? = null,
)
