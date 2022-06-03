package io.aegires.kevsy

abstract class CancellableEvent: Event() {
    var cancelled = false
    fun cancel(){
        cancelled = true
    }
}
