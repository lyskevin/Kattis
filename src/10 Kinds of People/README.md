# Link

https://open.kattis.com/problems/10kindsofpeople

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. Uses multi-source BFS and a boolean array to keep track of which nodes have been visited before so that the BFS algorithm isn't run more than once on those nodes. A union-find data structure with path compression (source code from Princeton University) is used to connect the nodes within each connected component so that subsequent queries can be answered in O(1) time. I initially used DFS since it is slightly easier to code but I got the Memory Limit Exceeded (MLE) verdict. I suspect that this is due to stack overflow since the DFS algorithm uses recursion and the problem's large upper limit in terms of the number of nodes could have caused this.

## 11/04/2020
Added solution code which makes use of only UFDS to solve the problem.

