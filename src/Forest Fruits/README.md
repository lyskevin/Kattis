# Link

https://open.kattis.com/problems/forestfruits

## Personal Thoughts

Problem that I attempted during AY20/21 Semester 1. Form the DIjkstra's spanning tree and store the distances to all clearings in a PQ. If the size of the PQ is <= min(K, M), then poll min(K, M) - 1 times from the PQ and the first remaining entry in the PQ will be the answer. Otherwise, it is not possible to keep getting fruits under the given constraints.

