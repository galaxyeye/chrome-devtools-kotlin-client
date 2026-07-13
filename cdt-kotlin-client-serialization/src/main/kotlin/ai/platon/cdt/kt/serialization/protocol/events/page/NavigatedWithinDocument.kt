@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.NavigatedWithinDocumentNavigationType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
 */
@Serializable
@Experimental
data class NavigatedWithinDocument(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("navigationType")
  val navigationType: NavigatedWithinDocumentNavigationType,
)
