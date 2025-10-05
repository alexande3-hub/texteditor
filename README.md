# CSC 207: Text Editor

**Author**: Isaac Alexander

## Resources Used

+ _(TODO: fill me in)_
+ ...
+ ...

## Changelog

_(TODO: fill me in with a log of your committed changes)_



Simple String Buffer Analysis (insert function):

Relevant input: (n - i), where n is the size of the string minus 1, and m is the current index.

Critical operations: each call to sArray[].

Mathematical model: T(n - i) = 2(n - i) + 2

Big-O operation: T in O(n - i)


The insert function I implemented begins with string s having an extra space added to it in order to allocate space for the new character. The function then defines sArray as a character array of s (this action adds 1 to the mathematical model), with the size sz increasing by 1 following this definition. The main part of the function then occurs - starting at the right-most character in s - which should just be a space - and going backwards until it hits the current index, a for loop changes each character to the character that precedes it, which loops approximately ((sz - 1) - i), with (sz - 1) representing the ending index of the string and i representing the goal index. Since sArray[] is called twice in each iteration, this adds 2(n - i) to the mathematical model. Finally, sArray[] is called once more to change the current index's character into the input character (this action also adds 1 to the mathematical model, which means the mathematical model includes an extra +2 in total).