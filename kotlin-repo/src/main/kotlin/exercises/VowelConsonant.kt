package exercises

fun countVowels(phrase: String): Int {
    val VOLWES = "aeiou"
    var totalVowels = 0

    for(letter in phrase) {
        if (letter.toLowerCase() in VOLWES) {
            totalVowels++
        }
    }

    return totalVowels;
}

fun countConsonants(phrase: String): Int {
    val CONSONANTS = "bcdfghjklmnpqrstvwxz"
    var totalConsonants = 0

    for(letter in phrase) {
        if (letter.toLowerCase() in CONSONANTS) {
            totalConsonants++
        }
    }

    return totalConsonants;
}