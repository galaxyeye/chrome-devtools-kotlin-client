@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.autofill

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Specified whether a filled field was done so by using the html autocomplete attribute or autofill heuristics.
 */
public enum class FillingStrategy {
  @JsonProperty("autocompleteAttribute")
  AUTOCOMPLETE_ATTRIBUTE,
  @JsonProperty("autofillInferred")
  AUTOFILL_INFERRED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
