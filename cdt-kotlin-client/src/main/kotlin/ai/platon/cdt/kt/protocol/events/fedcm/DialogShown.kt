@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.fedcm

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.fedcm.Account
import ai.platon.cdt.kt.protocol.types.fedcm.DialogType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class DialogShown(
  @param:JsonProperty("dialogId")
  val dialogId: String,
  @param:JsonProperty("dialogType")
  val dialogType: DialogType,
  @param:JsonProperty("accounts")
  val accounts: List<Account>,
  @param:JsonProperty("title")
  val title: String,
  @param:JsonProperty("subtitle")
  @param:Optional
  val subtitle: String? = null,
)
