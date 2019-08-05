# Link

https://open.kattis.com/problems/emergency

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. At first glance, this seems like a graph problem. However, given the large upper bound on the input data, the usual graph algorithms will probably result in a Time Limit Exceeded (TLE) verdict. On further inspection, I realised that the problem could be broken down into 3 steps:

1. Find the number of steps from node 0 to node k (k steps)
2. Find the number of steps from node k to the highest multiple of k which is less than or equal to n (1 step)
3. Find the number of steps from said node in step 2 to n ((n - 1) % k steps)

Hence, the number of steps from node 0 to node n is simply k + 1 + ((n - 1) % k), which gives us a nice constant-time algorithm. Of course, if n - 1 is less than 2k, the number of steps is then n - 1.

