# Link

https://open.kattis.com/problems/robotopia

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by performing a complete search over the range of possible values for one variable, and checking if the computed value of the other variable matches both linear equations. The catch is that both variables must be greater than or equal to 1, as stated in the question. I initially tried to solve this problem by performing Gauss Jordan elimination, but it does not work because of the aforementioned condition. The final augmented matrix could indicate the presence of multiple solutions when there might only be one solution if we restrict the values of both variables to be at least 1.

