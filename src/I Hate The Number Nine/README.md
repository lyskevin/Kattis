# Link

https://open.kattis.com/problems/nine

## Personal Thoughts
Problem that I attempted during the summer holidays of 2020. Can be solved by using modular exponentiation after finding the general formula for u(n).

Notice that u(n) = 8 * u(n - 1) (for 11 to 18, 21 to 28, etc.) + u(n - 1) (for 10, 20, ..., 80) = 9 * u(n - 1) = 9<sup>n - 1</sup> * u(1) = 9<sup>n - 1</sup> * 8

