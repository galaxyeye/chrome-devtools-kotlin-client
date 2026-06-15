@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

@Experimental
@Serializable
data class SecurityIsolationStatus(
  @SerialName("coop")
  @param:Optional
  val coop: CrossOriginOpenerPolicyStatus? = null,
  @SerialName("coep")
  @param:Optional
  val coep: CrossOriginEmbedderPolicyStatus? = null,
)
