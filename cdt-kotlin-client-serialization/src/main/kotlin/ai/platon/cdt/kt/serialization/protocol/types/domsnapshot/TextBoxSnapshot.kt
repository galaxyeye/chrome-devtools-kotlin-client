@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import kotlin.Double
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Table of details of the post layout rendered text positions. The exact layout should not be regarded as
 * stable and may change between versions.
 */
@Serializable
data class TextBoxSnapshot(
  @property:SerialName("layoutIndex")
  val layoutIndex: List<Int>,
  @property:SerialName("bounds")
  val bounds: List<List<Double>>,
  @property:SerialName("start")
  val start: List<Int>,
  @property:SerialName("length")
  val length: List<Int>,
)
