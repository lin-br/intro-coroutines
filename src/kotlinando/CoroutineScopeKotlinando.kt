package kotlinando

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // cria um CoroutineScope
    doWorldOne() // executa primeiro
    doWorldTwo() // executa depois que o primeiro termina
}

suspend fun doWorldOne() = coroutineScope { // cria um CoroutineScope
    launch { // cria uma coroutine independente, o código continua executando
        delay(2000L) // cria um delay não bloqueante
        println("1 - World!")
    }
    println("1 - Hello") // escreve esse statement no console antes mesmo do bloco do launch{}
}

suspend fun doWorldTwo() = coroutineScope { // cria um CoroutineScope
    launch { // cria uma coroutine independente, o código continua executando
        delay(1000L) // cria um delay não bloqueante
        println("2 - World!")
    }
    println("2 - Hello") // escreve esse statement no console antes mesmo do bloco do launch{}
}