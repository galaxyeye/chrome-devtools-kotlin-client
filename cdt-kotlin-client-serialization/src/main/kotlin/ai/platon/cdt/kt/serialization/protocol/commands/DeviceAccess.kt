@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.events.deviceaccess.DeviceRequestPrompted
import ai.platon.cdt.kt.serialization.protocol.support.annotations.EventName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import kotlin.String
import kotlin.Unit

@Experimental
interface DeviceAccess {
  /**
   * Enable events in this domain.
   */
  suspend fun enable()

  /**
   * Disable events in this domain.
   */
  suspend fun disable()

  /**
   * Select a device in response to a DeviceAccess.deviceRequestPrompted event.
   * @param id
   * @param deviceId
   */
  suspend fun selectPrompt(@ParamName("id") id: String, @ParamName("deviceId") deviceId: String)

  /**
   * Cancel a prompt in response to a DeviceAccess.deviceRequestPrompted event.
   * @param id
   */
  suspend fun cancelPrompt(@ParamName("id") id: String)

  @EventName("deviceRequestPrompted")
  fun onDeviceRequestPrompted(eventListener: EventHandler<DeviceRequestPrompted>): EventListener

  @EventName("deviceRequestPrompted")
  fun onDeviceRequestPrompted(eventListener: suspend (DeviceRequestPrompted) -> Unit): EventListener
}
