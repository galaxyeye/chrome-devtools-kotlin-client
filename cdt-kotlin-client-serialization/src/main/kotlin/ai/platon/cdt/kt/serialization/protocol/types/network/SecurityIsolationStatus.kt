@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SecurityIsolationStatus(
  @property:SerialName("coop")
  @param:Optional
  val coop: CrossOriginOpenerPolicyStatus? = null,
  @property:SerialName("coep")
  @param:Optional
  val coep: CrossOriginEmbedderPolicyStatus? = null,
)
