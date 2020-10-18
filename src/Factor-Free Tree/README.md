# Link

https://open.kattis.com/problems/factorfree

## Personal Thoughts

Problem that I attempted during AY20/21 Semester 1. Can be solved by factorising each number into its prime factors and storing left and right "bounds" on the positions of prime factors. These bounds can then be used to check that a number if coprime with all of the other numbers within the given range of indices in O(1) or O(log n) time (depending on the implementation). When choosing a number as the root of the current subtree, we iterate from left to right and right to left simultaneously to prevent the worst case O(n^2) time (we get an O(n log n) algorithm by doing this simultaneous iteration).

