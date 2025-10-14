package ai.platon.cdt.kt.protocol.support.types

interface EventHandler<T> {
    /**
     * Handles the event of type T.
     *
     * @param event Event
     */
    suspend fun onEvent(event: T)
}

interface EventListener {
    /** Alias to unsubscribe.  */
    fun off()

    /** Unsubscribe this event listener.  */
    fun unsubscribe()
}
