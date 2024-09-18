package kotlinando

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne() // vai ser executado primeiro, com delay de 1 segundo
        val two = doSomethingUsefulTwo() // vai ser executado depois, com delay de 1 segundo
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms") // o tempo vai ser maior que 2 segundos
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return Random.nextInt(0, 1000)
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return Random.nextInt(0, 1000)
}