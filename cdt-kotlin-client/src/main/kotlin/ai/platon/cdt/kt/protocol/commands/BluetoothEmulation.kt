@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.bluetoothemulation.CharacteristicOperationReceived
import ai.platon.cdt.kt.protocol.events.bluetoothemulation.DescriptorOperationReceived
import ai.platon.cdt.kt.protocol.events.bluetoothemulation.GattOperationReceived
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.CentralState
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.CharacteristicOperationType
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.CharacteristicProperties
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.DescriptorOperationType
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.GATTOperationType
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.ManufacturerData
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.ScanEntry
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * This domain allows configuring virtual Bluetooth devices to test
 * the web-bluetooth API.
 */
@Experimental
interface BluetoothEmulation {
  /**
   * Enable the BluetoothEmulation domain.
   * @param state State of the simulated central.
   * @param leSupported If the simulated central supports low-energy.
   */
  suspend fun enable(@ParamName("state") state: CentralState, @ParamName("leSupported") leSupported: Boolean)

  /**
   * Set the state of the simulated central.
   * @param state State of the simulated central.
   */
  suspend fun setSimulatedCentralState(@ParamName("state") state: CentralState)

  /**
   * Disable the BluetoothEmulation domain.
   */
  suspend fun disable()

  /**
   * Simulates a peripheral with |address|, |name| and |knownServiceUuids|
   * that has already been connected to the system.
   * @param address
   * @param name
   * @param manufacturerData
   * @param knownServiceUuids
   */
  suspend fun simulatePreconnectedPeripheral(
    @ParamName("address") address: String,
    @ParamName("name") name: String,
    @ParamName("manufacturerData") manufacturerData: List<ManufacturerData>,
    @ParamName("knownServiceUuids") knownServiceUuids: List<String>,
  )

  /**
   * Simulates an advertisement packet described in |entry| being received by
   * the central.
   * @param entry
   */
  suspend fun simulateAdvertisement(@ParamName("entry") entry: ScanEntry)

  /**
   * Simulates the response code from the peripheral with |address| for a
   * GATT operation of |type|. The |code| value follows the HCI Error Codes from
   * Bluetooth Core Specification Vol 2 Part D 1.3 List Of Error Codes.
   * @param address
   * @param type
   * @param code
   */
  suspend fun simulateGATTOperationResponse(
    @ParamName("address") address: String,
    @ParamName("type") type: GATTOperationType,
    @ParamName("code") code: Int,
  )

  /**
   * Simulates the response from the characteristic with |characteristicId| for a
   * characteristic operation of |type|. The |code| value follows the Error
   * Codes from Bluetooth Core Specification Vol 3 Part F 3.4.1.1 Error Response.
   * The |data| is expected to exist when simulating a successful read operation
   * response.
   * @param characteristicId
   * @param type
   * @param code
   * @param data
   */
  suspend fun simulateCharacteristicOperationResponse(
    @ParamName("characteristicId") characteristicId: String,
    @ParamName("type") type: CharacteristicOperationType,
    @ParamName("code") code: Int,
    @ParamName("data") @Optional `data`: String? = null,
  )

  suspend fun simulateCharacteristicOperationResponse(
    @ParamName("characteristicId") characteristicId: String,
    @ParamName("type") type: CharacteristicOperationType,
    @ParamName("code") code: Int,
  ) {
    return simulateCharacteristicOperationResponse(characteristicId, type, code, null)
  }

  /**
   * Simulates the response from the descriptor with |descriptorId| for a
   * descriptor operation of |type|. The |code| value follows the Error
   * Codes from Bluetooth Core Specification Vol 3 Part F 3.4.1.1 Error Response.
   * The |data| is expected to exist when simulating a successful read operation
   * response.
   * @param descriptorId
   * @param type
   * @param code
   * @param data
   */
  suspend fun simulateDescriptorOperationResponse(
    @ParamName("descriptorId") descriptorId: String,
    @ParamName("type") type: DescriptorOperationType,
    @ParamName("code") code: Int,
    @ParamName("data") @Optional `data`: String? = null,
  )

  suspend fun simulateDescriptorOperationResponse(
    @ParamName("descriptorId") descriptorId: String,
    @ParamName("type") type: DescriptorOperationType,
    @ParamName("code") code: Int,
  ) {
    return simulateDescriptorOperationResponse(descriptorId, type, code, null)
  }

  /**
   * Adds a service with |serviceUuid| to the peripheral with |address|.
   * @param address
   * @param serviceUuid
   */
  @Returns("serviceId")
  suspend fun addService(@ParamName("address") address: String, @ParamName("serviceUuid") serviceUuid: String): String

  /**
   * Removes the service respresented by |serviceId| from the simulated central.
   * @param serviceId
   */
  suspend fun removeService(@ParamName("serviceId") serviceId: String)

  /**
   * Adds a characteristic with |characteristicUuid| and |properties| to the
   * service represented by |serviceId|.
   * @param serviceId
   * @param characteristicUuid
   * @param properties
   */
  @Returns("characteristicId")
  suspend fun addCharacteristic(
    @ParamName("serviceId") serviceId: String,
    @ParamName("characteristicUuid") characteristicUuid: String,
    @ParamName("properties") properties: CharacteristicProperties,
  ): String

  /**
   * Removes the characteristic respresented by |characteristicId| from the
   * simulated central.
   * @param characteristicId
   */
  suspend fun removeCharacteristic(@ParamName("characteristicId") characteristicId: String)

  /**
   * Adds a descriptor with |descriptorUuid| to the characteristic respresented
   * by |characteristicId|.
   * @param characteristicId
   * @param descriptorUuid
   */
  @Returns("descriptorId")
  suspend fun addDescriptor(@ParamName("characteristicId") characteristicId: String, @ParamName("descriptorUuid") descriptorUuid: String): String

  /**
   * Removes the descriptor with |descriptorId| from the simulated central.
   * @param descriptorId
   */
  suspend fun removeDescriptor(@ParamName("descriptorId") descriptorId: String)

  /**
   * Simulates a GATT disconnection from the peripheral with |address|.
   * @param address
   */
  suspend fun simulateGATTDisconnection(@ParamName("address") address: String)

  @EventName("gattOperationReceived")
  fun onGattOperationReceived(eventListener: EventHandler<GattOperationReceived>): EventListener

  @EventName("gattOperationReceived")
  fun onGattOperationReceived(eventListener: suspend (GattOperationReceived) -> Unit): EventListener

  @EventName("characteristicOperationReceived")
  fun onCharacteristicOperationReceived(eventListener: EventHandler<CharacteristicOperationReceived>): EventListener

  @EventName("characteristicOperationReceived")
  fun onCharacteristicOperationReceived(eventListener: suspend (CharacteristicOperationReceived) -> Unit): EventListener

  @EventName("descriptorOperationReceived")
  fun onDescriptorOperationReceived(eventListener: EventHandler<DescriptorOperationReceived>): EventListener

  @EventName("descriptorOperationReceived")
  fun onDescriptorOperationReceived(eventListener: suspend (DescriptorOperationReceived) -> Unit): EventListener
}
