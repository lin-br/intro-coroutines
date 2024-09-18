package kotlinando

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{ // cria um CoroutineScope
    launch { // cria uma coroutine independente, o código continua executando
        delay(1000L) // cria um delay não bloqueante
        println("World!")
    }
    println("Hello") // escreve esse statement no console antes mesmo do bloco do launch{}
}