# Link

https://open.kattis.com/problems/factovisors

## Personal Thoughts

Problem that I attempted during my winter break in 2019. I had a fair bit of touble with this one because I did not properly account for the edge cases, especially m == 0 and n == 0. Can be solved by comparing the prime factors of both numbers.

I initially referenced the solution here (https://github.com/fabianschilling/kattis/blob/master/factovisors/Main.java) because I thought that the constant factor in my code was too large (when comparing prime factors) but then I realised that the numerous Time Limit Exceeded (TLE) and Wrong Answer (WA) verdicts were due to the aforementioned edge cases.

