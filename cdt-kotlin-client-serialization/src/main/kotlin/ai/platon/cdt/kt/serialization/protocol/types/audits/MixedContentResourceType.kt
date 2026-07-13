@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MixedContentResourceType {
  @SerialName("AttributionSrc")
  ATTRIBUTION_SRC,
  @SerialName("Audio")
  AUDIO,
  @SerialName("Beacon")
  BEACON,
  @SerialName("CSPReport")
  CSP_REPORT,
  @SerialName("Download")
  DOWNLOAD,
  @SerialName("EventSource")
  EVENT_SOURCE,
  @SerialName("Favicon")
  FAVICON,
  @SerialName("Font")
  FONT,
  @SerialName("Form")
  FORM,
  @SerialName("Frame")
  FRAME,
  @SerialName("Image")
  IMAGE,
  @SerialName("Import")
  IMPORT,
  @SerialName("JSON")
  JSON,
  @SerialName("Manifest")
  MANIFEST,
  @SerialName("Ping")
  PING,
  @SerialName("PluginData")
  PLUGIN_DATA,
  @SerialName("PluginResource")
  PLUGIN_RESOURCE,
  @SerialName("Prefetch")
  PREFETCH,
  @SerialName("Resource")
  RESOURCE,
  @SerialName("Script")
  SCRIPT,
  @SerialName("ServiceWorker")
  SERVICE_WORKER,
  @SerialName("SharedWorker")
  SHARED_WORKER,
  @SerialName("SpeculationRules")
  SPECULATION_RULES,
  @SerialName("Stylesheet")
  STYLESHEET,
  @SerialName("Track")
  TRACK,
  @SerialName("Video")
  VIDEO,
  @SerialName("Worker")
  WORKER,
  @SerialName("XMLHttpRequest")
  XML_HTTP_REQUEST,
  @SerialName("XSLT")
  XSLT,
  UNKNOWN,
}
