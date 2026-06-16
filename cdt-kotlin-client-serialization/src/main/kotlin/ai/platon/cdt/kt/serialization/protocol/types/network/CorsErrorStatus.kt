@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CorsErrorStatus(
  @property:SerialName("corsError")
  val corsError: CorsError,
  @property:SerialName("failedParameter")
  val failedParameter: String,
)
