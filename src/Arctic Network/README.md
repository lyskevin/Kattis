# Link

https://open.kattis.com/problems/arcticnetwork

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. After some consideration, I realised that the problem can be boiled down to an MST one. Given a set number of outposts (P) and a set number of satellites (S), I would only have to choose P - S using Kruskal's algorithm, with the remaining S edges being connected with satellites. The distance of the last edge selected by the algorithm is then the required output. A union-find data structure with path compression (source code from Princeton University) is used to connect the nodes within the MST.

