# CSC 207: Text Editor

**Author**: Isaac Alexander

## Resources Used

+ Charlotte, Ben, and Candice (tutors) helped with this project.
+ Z (peer) helped with this project (conceptual Java questions).
+ Osera and course mentor David helped with this project.
+ The following Oracle docs helped me with this project:
https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html

## Changelog

# Starting the string buffer process.

# Made my first test and added string buffer comments.

# Beginning my README question 2 answer.

# Finished the gap buffer implementation!

# Working on the tests, finished part 2!

# Making great progress on the main function!

# Fixed a path issue (probably)

# Just need to figure out what's wrong with the getChar function in SSB… 

# Working on array non-pointer madnessmvn test

# These errors are beginning to drive me up a wall.

# Home stretch hopefully, fixed text character deal!

# Got most of the test fixed



Simple String Buffer Analysis (insert function):

Relevant input: (n - i), where n is the size of the string minus 1, and m is the current index.

Critical operations: each call to sArray[].

Mathematical model: T(n - i) = 2(n - i) + 2

Big-O operation: T in O(n - i)


Since strings in Java are immutable, preventing us from changing the string directly, the function must first define sArray as a character array of s (this action adds 1 to the mathematical model), with the size sz increasing by 1 following this definition. The main part of the mathematical model stems from the else branch in the main part of the function. Starting at the right-most character in s - which should just be a space - and going backwards until it hits the current index, a for loop changes each character to the character that precedes it, which loops approximately ((sz - 1) - i), with (sz - 1) representing the ending index of the string and i representing the goal index. Since sArray[] is called twice in each iteration, this adds 2(n - i) to the mathematical model. Finally, sArray[] is called once more to change the current index's character into the input character (this action also adds 1 to the mathematical model, which means the mathematical model includes an extra +2 in total). The function ends with s being redefined as the string equivalent of the new character array, as well as a call to moveRight.