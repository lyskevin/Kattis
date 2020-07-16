# Link

https://open.kattis.com/problems/nine

## Personal Thoughts
Problem that I attempted during the summer holidays of 2020. Can be solved by using modular exponentiation after finding the general formula for u(n).

Example for 2 digit numbers: u(2) = 8 * u(n - 1) (for 11 to 18, 21 to 28, ..., 81 to 88) + u(n - 1) (for 10, 20, ..., 80; we add this term because 0 is not counted inside u(1)) = 9 * u(1)

General formula =  = 9<sup>n - 1</sup> * u(1) = 9<sup>n - 1</sup> * 8

