@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.support.types

fun interface EventHandler<T> {
  suspend fun onEvent(event: T)
}

interface EventListener {
  /**
   * Alias to unsubscribe.  
   */
  fun off()

  /**
   * Unsubscribe this event listener.  
   */
  fun unsubscribe()
}
