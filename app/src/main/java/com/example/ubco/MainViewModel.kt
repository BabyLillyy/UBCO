package com.example.ubco

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun translateFromEng(input: String): String {
        var result = ""
        var whiteSpaceCount = 1

        input.forEach {
            val stringInput = it.toString()
            when {
                vowelsRegex.matches(stringInput) -> result += "$it$it"
                !alphaRegex.matches(stringInput) -> {
                    if (it == ' ' && result.last() != ' ') whiteSpaceCount++
                    result += it
                }
                else -> {
                    consonants.forEachIndexed { index, element ->
                        if (element == it) result += shiftedIndex(index, element)
                    }
                }
            }
        }

        return "$CONSTANT_WORD $result${whiteSpaceCount}"
    }

    fun shiftedIndex(index: Int, element: Char): Char {
        return when {
            consonants.last().equals(element, ignoreCase = true) -> {
                val changeChar = consonants.elementAt(0)
                if (element.isUpperCase()) changeChar.uppercaseChar()
                else changeChar.lowercaseChar()
            }
            else -> consonants.elementAt(index + 1)
        }
    }

    companion object {
        const val CONSTANT_WORD = "UBCO "
        val alphaRegex = Regex("[a-z]", RegexOption.IGNORE_CASE)
        val vowelsRegex = Regex("[aeiou]", RegexOption.IGNORE_CASE)
        val consonants = (('a'..'z').toList() + ('A'..'Z').toList()).filter {
            it !in listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        }
    }
}