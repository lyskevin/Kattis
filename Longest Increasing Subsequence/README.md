# Link

https://open.kattis.com/problems/longincsubseq

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by running the greedy Longest Increasing Subsequence (LIS) algorithm. The gist of it is to iterate through the given sequence of numbers and update an ArrayList L such that L[i] stores the index of the best possible ending number for an LIS of size i + 1; e.g. L[1] stores the best (lowest) possible ending number for an LIS of size 2. I decided to store indices in L because of the need to reconstruct the LIS, which can be done by maintaining a predecessor array while running the algorithm.

