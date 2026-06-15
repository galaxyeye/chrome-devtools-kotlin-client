@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Table of details of the post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
@Serializable
data class TextBoxSnapshot(
  @SerialName("layoutIndex")
  val layoutIndex: List<Int>,
  @SerialName("bounds")
  val bounds: List<List<Double>>,
  @SerialName("start")
  val start: List<Int>,
  @SerialName("length")
  val length: List<Int>,
)
