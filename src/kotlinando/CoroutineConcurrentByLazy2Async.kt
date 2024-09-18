package kotlinando

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() } // vai começar a ser executado apenas quando o START for dado
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() } // vai começar a ser executado apenas quando o START for dado
        println("The answer is ${one.await() + two.await()}") // inicia a execução dos dois, mas como foram iniciados por .await(), a execução aguarda o retorno do primeiro para então começar o segundo
    }
    println("Completed in $time ms") // o tempo vai ser maior que 2 segundos, pois eles são awaits mas foram iniciados com função que aguarda o retorno (.await())
}