@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.fedcm.DialogClosed
import ai.platon.cdt.kt.protocol.events.fedcm.DialogShown
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.fedcm.AccountUrlType
import ai.platon.cdt.kt.protocol.types.fedcm.DialogButton
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

/**
 * This domain allows interacting with the FedCM dialog.
 */
@Experimental
interface FedCm {
  /**
   * @param disableRejectionDelay Allows callers to disable the promise rejection delay that would
   * normally happen, if this is unimportant to what's being tested.
   * (step 4 of https://fedidcg.github.io/FedCM/#browser-api-rp-sign-in)
   */
  suspend fun enable(@ParamName("disableRejectionDelay") @Optional disableRejectionDelay: Boolean? = null)

  suspend fun enable() {
    return enable(null)
  }

  suspend fun disable()

  /**
   * @param dialogId
   * @param accountIndex
   */
  suspend fun selectAccount(@ParamName("dialogId") dialogId: String, @ParamName("accountIndex") accountIndex: Int)

  /**
   * @param dialogId
   * @param dialogButton
   */
  suspend fun clickDialogButton(@ParamName("dialogId") dialogId: String, @ParamName("dialogButton") dialogButton: DialogButton)

  /**
   * @param dialogId
   * @param accountIndex
   * @param accountUrlType
   */
  suspend fun openUrl(
    @ParamName("dialogId") dialogId: String,
    @ParamName("accountIndex") accountIndex: Int,
    @ParamName("accountUrlType") accountUrlType: AccountUrlType,
  )

  /**
   * @param dialogId
   * @param triggerCooldown
   */
  suspend fun dismissDialog(@ParamName("dialogId") dialogId: String, @ParamName("triggerCooldown") @Optional triggerCooldown: Boolean? = null)

  suspend fun dismissDialog(@ParamName("dialogId") dialogId: String) {
    return dismissDialog(dialogId, null)
  }

  /**
   * Resets the cooldown time, if any, to allow the next FedCM call to show
   * a dialog even if one was recently dismissed by the user.
   */
  suspend fun resetCooldown()

  @EventName("dialogShown")
  fun onDialogShown(eventListener: EventHandler<DialogShown>): EventListener

  @EventName("dialogShown")
  fun onDialogShown(eventListener: suspend (DialogShown) -> Unit): EventListener

  @EventName("dialogClosed")
  fun onDialogClosed(eventListener: EventHandler<DialogClosed>): EventListener

  @EventName("dialogClosed")
  fun onDialogClosed(eventListener: suspend (DialogClosed) -> Unit): EventListener
}
