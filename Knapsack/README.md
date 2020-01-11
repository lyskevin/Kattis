# Link

https://open.kattis.com/problems/knapsack

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by using the standard top-down 0-1 knapsack algorithm. There seems to be some bottleneck in my code even though I used the top-down approach, such that my Java solution results in a Time Limit Exceeded (TLE) verdict and even my C code runs in more than one second. I doubt that it is a problem with reconstructing the items since the upper limit is only 2000 and the input/output operations are also around that magnitude. I believe that the bottleneck stems from the way that I implemented the 0-1 knapsack algorithm but I do not know why it takes so long to execute.

