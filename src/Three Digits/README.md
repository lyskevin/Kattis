# Link

https://open.kattis.com/problems/threedigits

## Personal Thoughts

Problem that I attempted during my winter break in 2019. The main idea is to simulate factorial computation but trailing zeroes have to be removed and some number of rightmost digits have to be kept. I had quite a lot of Wrong Answer (WA) verdicts for this question. It seems that performing too many division operations inside the factorial simulation leads to some inaccuracies in the digits that are kept, and we cannot keep more than 11 digits without overflowing the long data type. It is infeasible to use the BigInteger class to maintain more digits because the computation is too slow for large values of n.

Since the number of fives will always be smaller than the number of twos, the number of tens (i.e. the number of trailing zeroes) is equal to the number of fives. We can get rid of all twos and fives as they appear, and then multiply the appropriate number of twos (number of twos - number of fives) after the factorial simulation has been completed. Solving the problem this way ensures that we have the required accuracy for the rightmost digits.

