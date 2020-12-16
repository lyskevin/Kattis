# Link

https://open.kattis.com/problems/landlocked

## Personal Thoughts

Problem that I attempted during the winter break of AY20/21. Use 0-1 BFS with water as the sources (using the individual countries as sources and running 0-1 BFS multiple times will result in a TLE verdict even though the runtime is still O(V + E)). I initially implemented 0-1 BFS wrongly by using both a visited and distances array, which caused many WA verdicts. The visited array cannot be used for 0-1 BFS because it might lead to some states getting wrongly used (i.e. choosing a state that gets offered to the back of the deque instead of a better state which ends up getting offered to the front of the deque at a later iteration of the same distance).

