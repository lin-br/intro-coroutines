package kotlinando

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() } // vai começar a ser executado e prosseguir com o código
        val two = async { doSomethingUsefulTwo() } // vai começar a ser executado e prosseguir com o código
        println("The answer is ${one.await() + two.await()}") // aguarda a execução dos dois e então soma o retorno
    }
    println("Completed in $time ms") // o tempo vai ser maior que 1 segundo mas menor que 2, diferente do outro
}