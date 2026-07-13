@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.pwa

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * The following types are the replica of
 * https://crsrc.org/c/chrome/browser/web_applications/proto/web_app_os_integration_state.proto;drc=9910d3be894c8f142c977ba1023f30a656bc13fc;l=67
 */
data class FileHandlerAccept(
  @param:JsonProperty("mediaType")
  val mediaType: String,
  @param:JsonProperty("fileExtensions")
  val fileExtensions: List<String>,
)
