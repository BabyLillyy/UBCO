# UBCO Technical Exercise project

### How the solution works

1. Input the English sentence.
2. Loop through the input text to check each character for a proper condition match.
3. Use the 'When' expression to define the condition box.
4. Initialize the variable "result" as an empty string to append the translation result.
5. First condition: Use a vowels regex to find vowels. If the character matches the vowelsRegex, double it and append it to the result variable.
6. Second condition: Use an alphabet regex to find a character that is not an English alphabet. It will return the original character. If it is a white space, it will increase the white space counter.
7. Else condition: Iterate through the consonants list to find the index of the character to shift it by one place to the next consonant in the alphabet, and append it to the result variable.
8. Conditions for shifting: First, if the last character is 'z' or 'Z', shift it to 'b' and check the case of the original character to define them accordingly. Second, get the next consonant and return it.
9. Store all return values of each condition in one place.
10. Final output: Concatenate the sentence 'UBCO [translated text][number of white spaces]'.

### Reasons for the technical decisions I have made
1. I was looping through the input text because it gives each character for checking the condition to translate it.
2. I used regex for proper condition matching and correct actions for translation.
3. 'whiteSpaceCount' keeps track of the number of words in the original text.
4. Store the append in one place for concatenation with the final output.

### Instructions for running my solution locally
1. Copy the link https://github.com/BabyLillyy/UBCO.git.
2. Go to Android Studio: File > New > Project from Version Control.

### What other things I would implement if I had more time, or what I would do differently in a 'real world' scenario.
1. Two-way communication: I would create another input to convert 'their' language to English for us to understand them.


## Video Record
[Screen_recording_20240618_205204.webm](https://github.com/BabyLillyy/UBCO/assets/161413035/e41dcde6-f819-42ac-942e-fce31799a963)
