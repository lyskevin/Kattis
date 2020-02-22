# Link

https://open.kattis.com/problems/numbertree

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. The problem seems more complicated than it actually is. Upon closer inspection, we see that we can number each node in the binary search tree normally (i.e. 1 at the root, 2 and 3 as its children, etc.) and then traverse the tree. When we reach our destination, we take the total number of nodes and subtract (the current node's number - 1) from it to get the numbering that we desire.

