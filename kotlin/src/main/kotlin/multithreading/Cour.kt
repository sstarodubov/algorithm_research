package multithreading

import kotlinx.coroutines.*
import java.util.TreeMap
import java.util.concurrent.Executors

val eHandlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
    println(throwable.message)
}

val e = Executors.newCachedThreadPool()
val scope = CoroutineScope(e.asCoroutineDispatcher() + eHandlerException)

fun main(): Unit {
    println(rest())

    println("finnish")
}

fun rest(): String = runBlocking {
    println(Thread.currentThread().name)
    scope.launch {
        delay(2000)
        println("do useful")
    }

    scope.launch {

        delay(2000)
        println("dddd")
    }


    return@runBlocking "response"
}




