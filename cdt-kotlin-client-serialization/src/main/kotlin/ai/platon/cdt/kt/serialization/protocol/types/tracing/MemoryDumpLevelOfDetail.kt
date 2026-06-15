@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details exposed when memory request explicitly declared.
 * Keep consistent with memory_dump_request_args.h and
 * memory_instrumentation.mojom
 */
@Serializable
public enum class MemoryDumpLevelOfDetail {
  @SerialName("background")
  BACKGROUND,
  @SerialName("light")
  LIGHT,
  @SerialName("detailed")
  DETAILED,
}
