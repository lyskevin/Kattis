# Link

https://open.kattis.com/problems/rationalratios

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Let m be the given rational number, n be the number of repeating digits in m, and d be the number of digits after the decimal point. The algorithm which I used can then be generalized as follows:
1. Define q = 10<sup>d - n</sup>.
2. The numerator is equal to m * 10<sup>n</sup> - m.
3. The denominator is equal to (10<sup>n</sup> - 1) * q.
4. Find the greatest common denominator (gcd) of the numerator and denominator and use it to simplify the fraction.

I used the BigInteger class to implement the algorithm as working with doubles results in some level of imprecision.

