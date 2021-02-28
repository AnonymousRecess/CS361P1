# Project 1: Deterministic Finite Automata

* Author: Jeff Kahn, Jackson Edwards
* Class: CS361 Section 2
* Semester: Spring 2021

## Overview

This Java project takes in a file with start states, final states, alphabet, and accepted transitions. The program emulates a Deterministic Finite Automata with state transitions that can be utilized in order to traverse given strings to determine if the string belongs in the language of the DFA that has been specified by the user.

INPUT: 

Given p1tc1.txt contains <br>
```
b <br>
a <br>
a0a a1b b0a b1b <br>
0 <br>
1 <br>
00 <br>
101 <br>
E
```
OUTPUT: 
```
Q = { b a }
Sigma = { 0 1 }
delta =
0 1
b a b
a a b
q0 = a
F = { b }
no
yes
no
yes
No
```
## Compiling and Using

To compile, execute the following command in the main project directory:
```
$ javac *.java
```

Run the compiled class with the command:
```
$ java fa.dfa.DFADriver <test_file_name>

The output information to the console displays (in-order) states, alphabet, transitions, start state, final states and a yes/no result for each tested string

## Discussion

When building the methods for this project, we had some issues keeping track of certain states with our implementations. We probably could have made it more simple by removing one of our state containers. Another simplification that could’ve made life easier, would have been to make our startState variable a String with the name instead of trying to keep it maintained alongside the state we had inside of our comprehensive container. Our debugging phase took nearly as long as the coding phase. 

Some of our struggles came in our accepts method and toString method. The majority of our debugging was because of these classes. The original test cases were fairly simple to pass. However, we had an excellent additional test case from Piazza that we also tested to find a few flaws in our implementation. Namely, re-adding existing states, out of date initial states, and empty transitions. In toString() we had to figure out the correct spacing between elements in our FA definition. 

When developing our program we sought after an eclipse extension that would allow us to pair program simultaneously. The extension was called codeTogether. This was a very effective tool that helped us streamline source code development. 

## Sources used

- Boise State CS 361: Project 1 (Deterministic Finite Automata)
Provided the following files that went unmodified
fa.dfa.DFADriver
Fa.dfa
DFAInterface 
fa.FAInterface 
fa.State 

