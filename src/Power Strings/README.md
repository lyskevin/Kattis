# Link

https://open.kattis.com/problems/powerstrings

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by using the Knuth-Morris-Pratt (KMP) string matching algorithm and by finding s in s + s. If s = a<sup>n</sup>, then s + s = a<sup>2n</sup>. The index of the second occurrence of s in s + s is the length of a. We divide the length of s by the length of a to find n.

