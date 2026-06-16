@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppManifest(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("errors")
  val errors: List<AppManifestError>,
  @property:SerialName("data")
  @param:Optional
  val `data`: String? = null,
  @property:SerialName("parsed")
  @param:Optional
  @param:Experimental
  val parsed: AppManifestParsedProperties? = null,
)
