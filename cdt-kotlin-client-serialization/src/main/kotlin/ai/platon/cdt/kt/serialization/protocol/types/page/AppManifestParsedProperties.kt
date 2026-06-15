@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Parsed app manifest properties.
 */
@Experimental
@Serializable
data class AppManifestParsedProperties(
  @SerialName("scope")
  val scope: String,
)
