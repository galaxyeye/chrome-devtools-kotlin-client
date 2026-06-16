@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Parsed app manifest properties.
 */
@Serializable
@Experimental
data class AppManifestParsedProperties(
  @property:SerialName("scope")
  val scope: String,
)
