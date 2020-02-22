# Link

https://open.kattis.com/problems/ones

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by making use of the following identities in modular arithmetic:

1. (a * b) % m = ((a % m) * (b % m)) % m
2. (a + b) % m = ((a % m) + (b % m)) % m

For the given sequence, a given number is equal to 10 times of the previous number plus 1. For example, 111 = 10 * 11 + 1. 

We let the specified input number be m. Then by using the above observation in conjunction with the two identities, we get u<sub>n</sub> = (((10 % m) * u<sub>n - 1</sub>) % m + (1 % m)) % m. We can continue iterating until u<sub>n</sub> % m == 0. The value of n is the desired output.

