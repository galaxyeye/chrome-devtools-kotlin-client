@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Navigate(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("loaderId")
  @param:Optional
  val loaderId: String? = null,
  @property:SerialName("errorText")
  @param:Optional
  val errorText: String? = null,
  @property:SerialName("isDownload")
  @param:Optional
  @param:Experimental
  val isDownload: Boolean? = null,
)
