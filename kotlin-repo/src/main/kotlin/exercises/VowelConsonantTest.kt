package exercises

import org.junit.Assert
import org.junit.Test

class VowelConsonantTest {

    @Test
    fun countVowels() {
        Assert.assertEquals(11, countVowels("Quantas vogais tem esta frase?"))
    }

    @Test
    fun countConsonants() {
        Assert.assertEquals(21, countConsonants("Geralmente uma frase possui mais consoantes!"))
    }

    @Test
    fun countVowelsAndConsonants() {
        val phrase = "Estou gostando muito de aprender kotlin!"

        Assert.assertEquals(15, countVowels(phrase))
        Assert.assertEquals(19, countConsonants(phrase))
    }
}