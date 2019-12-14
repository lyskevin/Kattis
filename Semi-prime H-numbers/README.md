# Link

https://open.kattis.com/problems/hnumbers

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by first precalculating and memoizing all the semi-prime h-numbers, and then storing the number of semi-prime h-numbers between 1 and h inclusive, for h in the range [1, 1000001]. Each query can subsequently be answered in O(1) time.

