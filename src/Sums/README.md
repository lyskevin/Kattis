# Link

https://open.kattis.com/problems/consecutivesums

## Personal Thoughts

Problem that I attempted during my winter break in 2019. We first define the following variables:

1. k: The number of summands to use
2. a: The first term in the arithmetic progression (with difference 1) to sum
3. n: The given number

By using the sum of arithmetic progression formula, we can deduce that k * (2a + k - 1) = 2n. k and (2a + k - 1) are factors of 2n, so we find the distinct factors of 2n and test each of them to find the smallest value of k, which then yields the smallest number of summands. We keep track of every distinct factor of 2n that has been computed so that we do not compute them again.

