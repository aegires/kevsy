package io.aegires.kevsy

interface IEventBus {
    fun <T: Event>post(event: T)
    fun <T: Event>subscribe(event: T, f: (T)->Unit)
}
