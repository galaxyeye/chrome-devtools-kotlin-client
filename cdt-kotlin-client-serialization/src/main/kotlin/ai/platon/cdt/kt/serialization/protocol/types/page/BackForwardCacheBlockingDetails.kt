@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class BackForwardCacheBlockingDetails(
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("function")
  @param:Optional
  val function: String? = null,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
)
