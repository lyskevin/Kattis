# Link

https://open.kattis.com/problems/palindromesubstring

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by checking all possible substrings of length 2 and above, and storing them in a sorted set if they are palindromes. Some optimisation is needed to pass the time limit; substrings should be checked from their middle characters instead of being generated iteratively using their starting characters so that iteration can be terminated early once a substring is found to not be a palindrome.

