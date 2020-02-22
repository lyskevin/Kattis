# Link

https://open.kattis.com/problems/hnumbers

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by first precalculating and memoizing all the semi-prime h-numbers, and then storing the number of semi-prime h-numbers between 1 and h inclusive, for h in the range [1, 1000001]. Each query can subsequently be answered in O(1) time.

For the numbers array, 0 represents prime h-prime numbers, 1 represents h-semi-prime numbers, and 2 represents h-composite numbers. The product of two h-prime numbers is a h-semi-prime number. If one of the two multiplicands is not h-prime (i.e. it is either h-semi-prime or h-composite), then the resulting product must be a h-composite number.

