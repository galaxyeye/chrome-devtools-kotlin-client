@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class MixedContentResourceType {
  @JsonProperty("AttributionSrc")
  ATTRIBUTION_SRC,
  @JsonProperty("Audio")
  AUDIO,
  @JsonProperty("Beacon")
  BEACON,
  @JsonProperty("CSPReport")
  CSP_REPORT,
  @JsonProperty("Download")
  DOWNLOAD,
  @JsonProperty("EventSource")
  EVENT_SOURCE,
  @JsonProperty("Favicon")
  FAVICON,
  @JsonProperty("Font")
  FONT,
  @JsonProperty("Form")
  FORM,
  @JsonProperty("Frame")
  FRAME,
  @JsonProperty("Image")
  IMAGE,
  @JsonProperty("Import")
  IMPORT,
  @JsonProperty("JSON")
  JSON,
  @JsonProperty("Manifest")
  MANIFEST,
  @JsonProperty("Ping")
  PING,
  @JsonProperty("PluginData")
  PLUGIN_DATA,
  @JsonProperty("PluginResource")
  PLUGIN_RESOURCE,
  @JsonProperty("Prefetch")
  PREFETCH,
  @JsonProperty("Resource")
  RESOURCE,
  @JsonProperty("Script")
  SCRIPT,
  @JsonProperty("ServiceWorker")
  SERVICE_WORKER,
  @JsonProperty("SharedWorker")
  SHARED_WORKER,
  @JsonProperty("SpeculationRules")
  SPECULATION_RULES,
  @JsonProperty("Stylesheet")
  STYLESHEET,
  @JsonProperty("Track")
  TRACK,
  @JsonProperty("Video")
  VIDEO,
  @JsonProperty("Worker")
  WORKER,
  @JsonProperty("XMLHttpRequest")
  XML_HTTP_REQUEST,
  @JsonProperty("XSLT")
  XSLT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
