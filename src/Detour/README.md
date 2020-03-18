# Link

https://open.kattis.com/problems/detour

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by running Dijkstra's algorithm using Amsterdam as the source and removing all outgoing edges which are part of the shortest path to Amsterdam from all vertices. The BFS algorithm can then be run with Delft as the source to check if it is connected to Amsterdam. I initially misunderstood the question and only removed outgoing edges from vertices along the shortest path from Delft to Amsterdam, which resulted in quite a few Wrong Answer verdicts.

