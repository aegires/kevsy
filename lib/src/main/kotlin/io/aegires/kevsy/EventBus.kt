package io.aegires.kevsy

import java.util.LinkedList

object EventBus: IEventBus {
    private val eventMap: MutableMap<Class<Event>, LinkedList<(Event)->Unit>> = mutableMapOf()
    override fun <T : Event> post(event: T) {
        if(!eventMap.containsKey(event.javaClass))
            return

        for(listener in eventMap[event.javaClass]!!) {
            listener(event)
            if(event is CancellableEvent && event.cancelled) break
        }
    }

    override fun <T : Event> subscribe(event: T, f: (T) -> Unit) {
        if(!eventMap.containsKey(event.javaClass))
            eventMap[event.javaClass] = LinkedList<(Event)->Unit>()
        eventMap[event.javaClass]!!.addLast(f as ((Event) -> Unit)?)
    }
}
