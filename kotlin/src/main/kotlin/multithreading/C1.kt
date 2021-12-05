package multithreading

import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

//@OptIn(DelicateCoroutinesApi::class)
//fun main() = runBlocking {
//    val job = GlobalScope.launch { // root coroutine with launch
//        println("Throwing exception from launch")
//        throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
//    }
//    job.join()
//    println("Joined failed job")
//    val deferred = GlobalScope.async { // root coroutine with async
//        println("Throwing exception from async")
//        throw ArithmeticException() // Nothing is printed, relying on user to call await
//    }
//    try {
//        deferred.await()
//        println("Unreached")
//    } catch (e: ArithmeticException) {
//        println("Caught ArithmeticException")
//    }
//}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val job = launch {
            launch { hello("hello", 1000) }
            launch { hello("world", 900) }
        }
        job.join()
    }
    println(time)
}


suspend fun hello(name: String, dl: Long) {
    println("$name on  ${Thread.currentThread().name}")
    println("start $name")
    delay(dl)
    println("end $name")
}


