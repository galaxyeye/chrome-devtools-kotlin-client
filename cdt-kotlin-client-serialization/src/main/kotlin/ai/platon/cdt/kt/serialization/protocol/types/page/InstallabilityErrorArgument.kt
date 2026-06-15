@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

@Experimental
@Serializable
data class InstallabilityErrorArgument(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
