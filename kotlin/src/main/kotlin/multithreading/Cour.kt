package multithreading

import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

val eHandlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
    println(throwable.message)
}


val executorService: ExecutorService = Executors.newCachedThreadPool()

val scope = CoroutineScope(executorService.asCoroutineDispatcher())

fun main() = runBlocking {

        scope.launch {
            try {
                Thread.sleep(1000)
                throw RuntimeException("111")
                println("here1: " + Thread.currentThread().name)
            } catch (e: Exception) {
                println("ERROR")
                scope.coroutineContext.cancel()
            }
        }


        scope.launch {
            Thread.sleep(3000)
            if (this.isActive) {
                println("here2: " + Thread.currentThread().name)
            }
        }


    println("here")
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




