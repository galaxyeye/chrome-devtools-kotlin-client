@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceCodeLocation(
  @property:SerialName("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
)
