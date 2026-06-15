@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class CrossOriginEmbedderPolicyValue {
  @SerialName("None")
  NONE,
  @SerialName("CorsOrCredentialless")
  CORS_OR_CREDENTIALLESS,
  @SerialName("RequireCorp")
  REQUIRE_CORP,
}
