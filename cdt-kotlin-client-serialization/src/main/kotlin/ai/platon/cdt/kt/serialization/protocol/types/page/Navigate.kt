@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Serializable
data class Navigate(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("loaderId")
  @param:Optional
  val loaderId: String? = null,
  @SerialName("errorText")
  @param:Optional
  val errorText: String? = null,
)
