package multithreading

import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

val eHandlerException = CoroutineExceptionHandler { _, _ ->
    println("hoho")
}


val executorService: ExecutorService = Executors.newCachedThreadPool()

val scope = CoroutineScope(executorService.asCoroutineDispatcher())

suspend fun download(id: Int, time: Long, result: String, err: RuntimeException? = null): String {
    try {
        delay(time)
        err?.let { throw err }
        println("THREAD: ${Thread.currentThread().name}")
        println(id)
        return result
    } catch (e:Exception ) {
        print(e)
        print("hoho")
        println()
        throw e
    }
}

fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val job2 = scope.async {
            download(1, 5000, "world")
        }
        val job = scope.async {
            download(2, 2000, "hello", RuntimeException("errorrrrrrrrrrr"))
        }

        val ans = job.await() + job2.await()
        println(ans)
    }
    println("time: $time")

    // =============================
//        scope.launch {
//            try {
//                Thread.sleep(1000)
//                throw RuntimeException("111")
//                println("here1: " + Thread.currentThread().name)
//            } catch (e: Exception) {
//                println("ERROR")
//                scope.coroutineContext.cancel()
//            }
//        }
//
//
//        scope.launch {
//            Thread.sleep(3000)
//            if (this.isActive) {
//                println("here2: " + Thread.currentThread().name)
//            }
//        }
//
//
//    println("here")
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




