# Link

https://open.kattis.com/problems/sixdegrees

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by using BFS and pruning the search algorithm at a distance of 6. I initially tried to use HashMap<String, HashSet<String>> for my adjacency list but got a time limit exceeded verdict. Each device (String) has to be mapped to an integer to pass the time limit.

