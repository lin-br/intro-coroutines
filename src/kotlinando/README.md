# Sobre Coroutine (async the Kotlin way)
Coroutine são threads leves, diferentes das threads normais, são blocos de códigos assyncronos que são suspensos em tempo de execução.

## Coroutine interfaces
Job - é um bloco de código que roda em segundo plano, conceitualmente ele tem um ciclo de vida que pode ser finalizado ou cancelado.
Quando cancelado, ele cancela todos os filhos dependentes dele recursivamente

Deferred - uma extensão do Job, em outras linguagens pode ser chamada de Future or Promise, conceitualmente é a mesma coisa,
ele armazena um bloco de código para ser executado no futuro e promete um retorno.

Channel - é uma interface que garante uma comunicação primitiva entre coroutines, conceitualmente um Channel é similar ao
java.util.concurrent.BlockingQueue, mas não bloqueante.

## Coroutines functions
"launch {}" - é um construtor de coroutines (corountine builder) lançado dentro de um escopo coroutine,
lança uma coroutine concorrente ao código do mesmo nível, executa independente, e não é possível lançar essa função fora do escopo coroutine.
A função launch() retorna um Job.

"delay {}" - é uma função que suspende a coroutine no scopo que o método se encontra (ele suspende a coroutine, não bloqueia ela)

"runBlocking {}" - é um construtor de escopo coroutines mas é um tipo de função que faz uma ponto entre o que é não coroutine
e o que é coroutine (dentro do bloco de código).

"coroutineScope {}" - é um outro construtor de escopo coroutine mas a principal diferente entre ele e o runBlocking() é que o runBlocking() bloqueia
a thread principal até o fim da execução dos métodos filhos (dentro do bloco), já o coroutineScope() apenas suspende, liberando
a thread subjacente para outros usos. Por conta dessa diferença é normal dizer que runBlocking() é uma função regular e a coroutineScope() é uma
função de suspensão.

"suspend fun" - é uma declaração de uma função que só pode ser lançada dentro do escopo coroutine

"async {}" - é um construtor de coroutines, precisa ser lançado dentro do escopo coroutine, a principal diferença entre o async() e o launch()
é que o launch() não espera um retorno (retorna um Job), já o async() retorna um objeto Deferred.

## Coroutine examples
Como o "launch {}" lança um Job, é possível executar ele dessa forma:
```
val job = launch {
    delay(1000L)
    println("World!")
}
println("Hello")
job.join() // a thread principal espera a execução do job e então continua a execução para o próximo statement
println("Done")
```
