@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.fedcm

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.fedcm.Account
import ai.platon.cdt.kt.serialization.protocol.types.fedcm.DialogType
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DialogShown(
  @property:SerialName("dialogId")
  val dialogId: String,
  @property:SerialName("dialogType")
  val dialogType: DialogType,
  @property:SerialName("accounts")
  val accounts: List<Account>,
  @property:SerialName("title")
  val title: String,
  @property:SerialName("subtitle")
  @param:Optional
  val subtitle: String? = null,
)
