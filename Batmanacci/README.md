# Link

https://open.kattis.com/problems/batmanacci

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by pre-calculating the lengths of the first n strings and then using an iterative divide and conquer algorithm to find the kth letter in the nth string. I did not use a recursive method since it results in a StackOverflowError for large values of n.

My algorithm can probably be improved by using long instead of BigInteger when finding the lengths of the first n strings since k fits inside a long variable. Given that 100000 is the upper limit for n, the length of the strings quickly exceeds the maximum value of a long variable and can thus be disregarded.

