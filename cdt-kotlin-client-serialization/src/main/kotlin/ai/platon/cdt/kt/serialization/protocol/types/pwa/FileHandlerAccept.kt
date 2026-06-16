@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.pwa

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The following types are the replica of
 * https://crsrc.org/c/chrome/browser/web_applications/proto/web_app_os_integration_state.proto;drc=9910d3be894c8f142c977ba1023f30a656bc13fc;l=67
 */
@Serializable
data class FileHandlerAccept(
  @property:SerialName("mediaType")
  val mediaType: String,
  @property:SerialName("fileExtensions")
  val fileExtensions: List<String>,
)
