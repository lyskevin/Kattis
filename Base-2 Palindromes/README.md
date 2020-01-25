# Link

https://open.kattis.com/problems/base2palindrome

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by generating palindromes and counting those with 1s at both ends of their binary representation (i.e. no leading zeroes). For example, to generate palindromes of length 5, we consider palindromes of the form 0i0 and 1i1, where i is a length 3 palindrome, for all i. Furthermore, only palindromes of 1i1 are added to the counter which keeps track of the number of valid palindromes that have been generated so far.

