# CSC 207: Text Editor

**Author**: Isaac Alexander

## Resources Used
+ asciitable.com
+ javac 24.0.2
+ Oracle JDK
+ Charlotte, Ben, and Candice (tutors) helped with this project.
+ Z (peer) helped with this project (conceptual Java questions).
+ Osera and course mentor David helped with this project.
+ The following Oracle docs helped me with this project:
https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html

## Changelog

# Fixed comments that were either too long or had blank lines.

# Changed the constructor of SimpleStringBuffer so it doesn't take any parameters.

# Changed the constructor of GapBuffer so it doesn't take any parameters.

# Added more Oracle-related acknowledgements.



Simple String Buffer Analysis (insert function):

Relevant input: (n - i), where n is the size of the string minus 1, and m is the current index.

Critical operations: each call to sArray[].

Mathematical model: T(n - i) = 2(n - i) + 2

Big-O operation: T in O(n - i)


Since strings in Java are immutable, preventing us from changing the string directly, the function must first define sArray as a character array of s (this action adds 1 to the mathematical model), with the size sz increasing by 1 following this definition. The main part of the mathematical model stems from the else branch in the main part of the function. Starting at the right-most character in s - which should just be a space - and going backwards until it hits the current index, a for loop changes each character to the character that precedes it, which loops approximately ((sz - 1) - i), with (sz - 1) representing the ending index of the string and i representing the goal index. Since sArray[] is called twice in each iteration, this adds 2(n - i) to the mathematical model. Finally, sArray[] is called once more to change the current index's character into the input character (this action also adds 1 to the mathematical model, which means the mathematical model includes an extra +2 in total). The function ends with s being redefined as the string equivalent of the new character array, as well as a call to moveRight.