package kotlinando

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // cria um CoroutineScope
    launch { doWorld() } // cria uma coroutine independente, o código continua executando
    println("Hello") // escreve esse statement no console antes mesmo do bloco do launch{}
}

suspend fun doWorld() {
    delay(1000)  // cria um delay não bloqueante
    println("World")
}
