# Link

https://open.kattis.com/problems/nonprimefactors

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Each query can be answered by subtracting the number of prime factors from the number of divisors. Results should be cached and used to answer repeated queries; notice how q is in the range [1, 3000000] while i is in the range [2, 2000000]. I got the Time Limit Exceeded (TLE) verdict when I submitted my first solution which did not cache the results, though this can probably be avoided by further optimising the code (if possible) or using a faster I/O language (e.g. C++). I also pre-computed prime factors up to sqrt(2000000) for use in my other methods.

