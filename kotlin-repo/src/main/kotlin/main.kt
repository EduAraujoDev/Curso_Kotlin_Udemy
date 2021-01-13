fun main() {
    println("Olá mundo!")

    // Varies mutáveis
    var nome = "José da silva"
    nome = "José da Silva 2"

    // Variaveirs imutáveis
    val idade = 10

    val x = 1
    val y: Int


    val caracteristica = "show!"

    println("Kotlin é um alinguagem ${caracteristica.length}")

    val str = """teste teste
        |teste teste
        |teste teste
    """.trimMargin()

    val a = 10
    val b = 20
    val c = 30

    calculaBonus(a, b, c)

    val str2 = "lorem ipsum"
    str2.capitalize()
    str2.decapitalize()
    str2.contains("bla")
    str2.startsWith("l", false)
}

fun calculaBonus(a: Int, b: Int, c: Int) {
    println("O bônus é: ${a + b + c * 2}")
}

fun hello(nome: String) : String = "Olá, $nome"