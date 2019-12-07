# Link

https://open.kattis.com/problems/camels

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved as follows:

1. Count inversions between pairs of inputs (i.e. inputs 1 and 2, inputs 1 and 3, inputs 2 and 3) and sum all 3 numbers together.
2. Subtract the above sum divided by two from the total number of possible pairs, which is given by \frac{n(n - 1)}{2}.

This works because an inversion must appear between two pairs of inputs to be counted as an inversion across all 3 inputs.

