@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

@Serializable
data class SourceCodeLocation(
  @SerialName("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @SerialName("url")
  val url: String,
  @SerialName("lineNumber")
  val lineNumber: Int,
  @SerialName("columnNumber")
  val columnNumber: Int,
)
