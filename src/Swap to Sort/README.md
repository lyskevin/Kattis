# Link

https://open.kattis.com/problems/swaptosort

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. A union-find data structure with path compression (source code from Princeton University) is used to connect the numbers which can be swapped with one another. We can then iterate through the numbers and check if 1 is connected to n, 2 is connected to n - 1, etc. If this holds all the way to n/2 then it is possible to sort the array.

