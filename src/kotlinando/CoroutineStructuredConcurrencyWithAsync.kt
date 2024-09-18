package kotlinando

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    try {
        // Aqui a thread vai
        val time = measureTimeMillis { println("The answer is ${concurrentSum()}") }
        println("Completed in $time ms")
    } catch (e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

// Como o construtor da função async() é baseado em CoroutineScrope,
// nós utilizamos coroutineScope() que é uma função de suspensão para criar o escopo
suspend fun concurrentSum(): Int = coroutineScope {
    val one = async {
        try {
            delay(Long.MAX_VALUE) // simula uma espera alta
            Random.nextInt(0, 1000)
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}