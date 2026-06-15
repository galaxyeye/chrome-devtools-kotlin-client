@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

@Serializable
data class AppManifest(
  @SerialName("url")
  val url: String,
  @SerialName("errors")
  val errors: List<AppManifestError>,
  @SerialName("data")
  @param:Optional
  val `data`: String? = null,
  @SerialName("parsed")
  @param:Optional
  @param:Experimental
  val parsed: AppManifestParsedProperties? = null,
)
