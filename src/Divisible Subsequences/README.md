# Link

https://open.kattis.com/problems/divisible

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by iterating through the numbers and keeping track of the frequencies of remainders in the range [0, d) among all prior subsequences. The counter is then incremented by 1 whenever the remainder of the sum of all prior numbers (mod d) is 0 and incremented by k during every iteration, where k is the number of prior subsequences whose remainders (mod d) are 0.

