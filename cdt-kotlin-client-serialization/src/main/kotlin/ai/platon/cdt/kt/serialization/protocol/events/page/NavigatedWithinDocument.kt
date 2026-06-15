@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
 */
@Experimental
@Serializable
data class NavigatedWithinDocument(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("url")
  val url: String,
)
