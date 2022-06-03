package io.aegires.kevsy

inline fun <reified T: Event>on(noinline func: (T)->Unit){
    val clazz = T::class.java
    EventBus.subscribe(clazz.getDeclaredConstructor().newInstance(), func)
}
