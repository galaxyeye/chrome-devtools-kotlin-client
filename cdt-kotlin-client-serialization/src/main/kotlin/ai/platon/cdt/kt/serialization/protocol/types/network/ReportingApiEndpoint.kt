@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ReportingApiEndpoint(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("groupName")
  val groupName: String,
)
