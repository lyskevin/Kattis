# Link

https://open.kattis.com/problems/primes

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by generating numbers with the specified prime factors and storing them in a set. I initially used recursion with memoization but kept getting the Time Limit Exceeded (TLE) verdict. My solution code passed the time limit after changing the number generation method to use powers of prime factors in an iterative manner before recursively calling itself.

