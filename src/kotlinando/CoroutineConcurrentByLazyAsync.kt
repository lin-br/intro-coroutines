package kotlinando

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() } // vai começar a ser executado apenas quando foi requisitado: por .start() ou .await()
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() } // vai começar a ser executado apenas quando foi requisitado: por .start() ou .await()
        one.start() // iniciando o async
        two.start() // iniciando o async
        println("The answer is ${one.await() + two.await()}") // aguarda a execução dos dois e então soma o retorno
    }
    println("Completed in $time ms") // o tempo vai ser maior que 1 segundo mas menor que 2, diferente do outro
}