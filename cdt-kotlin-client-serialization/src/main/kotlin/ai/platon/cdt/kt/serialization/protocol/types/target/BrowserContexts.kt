@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.target

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BrowserContexts(
  @property:SerialName("browserContextIds")
  val browserContextIds: List<String>,
  @property:SerialName("defaultBrowserContextId")
  @param:Optional
  @param:Experimental
  val defaultBrowserContextId: String? = null,
)
