@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.autofill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specified whether a filled field was done so by using the html autocomplete attribute or autofill heuristics.
 */
@Serializable
public enum class FillingStrategy {
  @SerialName("autocompleteAttribute")
  AUTOCOMPLETE_ATTRIBUTE,
  @SerialName("autofillInferred")
  AUTOFILL_INFERRED,
  UNKNOWN,
}
