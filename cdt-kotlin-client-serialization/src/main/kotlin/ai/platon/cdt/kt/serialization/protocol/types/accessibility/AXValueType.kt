@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of possible property types.
 */
@Serializable
public enum class AXValueType {
  @SerialName("boolean")
  BOOLEAN,
  @SerialName("tristate")
  TRISTATE,
  @SerialName("booleanOrUndefined")
  BOOLEAN_OR_UNDEFINED,
  @SerialName("idref")
  IDREF,
  @SerialName("idrefList")
  IDREF_LIST,
  @SerialName("integer")
  INTEGER,
  @SerialName("node")
  NODE,
  @SerialName("nodeList")
  NODE_LIST,
  @SerialName("number")
  NUMBER,
  @SerialName("string")
  STRING,
  @SerialName("computedString")
  COMPUTED_STRING,
  @SerialName("token")
  TOKEN,
  @SerialName("tokenList")
  TOKEN_LIST,
  @SerialName("domRelation")
  DOM_RELATION,
  @SerialName("role")
  ROLE,
  @SerialName("internalRole")
  INTERNAL_ROLE,
  @SerialName("valueUndefined")
  VALUE_UNDEFINED,
  UNKNOWN,
}
