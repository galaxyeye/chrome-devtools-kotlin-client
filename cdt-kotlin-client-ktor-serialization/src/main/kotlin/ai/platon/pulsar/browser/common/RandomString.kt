package ai.platon.pulsar.browser.common

import kotlin.random.Random

object RandomString {
    private const val ALPHABET: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    fun nextAlphabetic(length: Int): String {
        val sb = StringBuilder(length)
        for (i in 0..<length) {
            sb.append(ALPHABET[Random.nextInt(ALPHABET.length)])
        }
        return sb.toString()
    }
}
