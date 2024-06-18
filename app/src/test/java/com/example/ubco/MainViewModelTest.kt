package com.example.ubco

import com.example.ubco.MainViewModel.Companion.consonants
import com.example.ubco.MainViewModel.Companion.CONSTANT_WORD
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var input1: String
    private lateinit var input2: String
    private lateinit var translatedInput1: String
    private lateinit var translatedInput2: String
    private lateinit var doubleVowelRegex: Regex

    @Before
    fun setUp() {
        viewModel = MainViewModel()
        input1 = "Hello World"
        input2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."

        translatedInput1 = "UBCO Jeemmoo Xoosmf2"
        translatedInput2 = "UBCO Mooseen iiqtuun foomoos tiiv aaneev, doopteedveevuus aafiiqiitdiiph eemiiv.8"
        doubleVowelRegex = Regex("([aeiou])\\1", RegexOption.IGNORE_CASE)
    }

    @Test
    fun `the sentence is start with a 'UBCO' will return TRUE`() {
        val translatedText = viewModel.translateFromEng(input1)
        assertTrue(translatedText.startsWith(CONSTANT_WORD))
    }

    @Test
    fun `the sentence is NOT start with a 'UBCO' will return FALSE`() {
        assertFalse(input1.startsWith(CONSTANT_WORD))
    }

    @Test
    fun `If the sentence contains the vowels will double it will return TRUE`() {
        val translatedText = viewModel.translateFromEng(input1)
        assertTrue(doubleVowelRegex.containsMatchIn(translatedText))
    }

    @Test
    fun `If the sentence contains the vowels but NOT double it will return FALSE`() {
        assertFalse(doubleVowelRegex.containsMatchIn(input1))
    }

    @Test
    fun `if input char is 'b' will shifted to 'c'`() {
        val shiftedText = viewModel.shiftedIndex(0, 'b')
        val expectedText = consonants.elementAt(1)
        assertEquals(shiftedText, expectedText)
    }

    @Test
    fun `if input char is 'c' will shifted to 'd'`() {
        val shiftedText = viewModel.shiftedIndex(1, 'c')
        val expectedText = consonants.elementAt(2)
        assertEquals(shiftedText, expectedText)
    }

    @Test
    fun `if input char is 'f' will shifted to 'g'`() {
        val shiftedText = viewModel.shiftedIndex(2, 'f')
        val expectedText = consonants.elementAt(3)
        assertEquals(shiftedText, expectedText)
    }

    @Test
    fun `if input char is 'h' will shifted to 'k'`() {
        val shiftedText = viewModel.shiftedIndex(3, 'h')
        val expectedText = consonants.elementAt(4)
        assertEquals(shiftedText, expectedText)
    }

    @Test
    fun `if input char is 'z' will shifted to 'b'`() {
        val shiftedText = viewModel.shiftedIndex(25, 'z')
        val expectedText = consonants.elementAt(0)
        assertEquals(shiftedText, expectedText)
    }

    @Test
    fun `if input char is 'Z' will shifted to 'B'`() {
        val shiftedText = viewModel.shiftedIndex(25, 'Z')
        val expectedText = consonants.elementAt(21)
        assertEquals(shiftedText, expectedText)
    }
}