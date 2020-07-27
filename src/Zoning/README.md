# Link

https://open.kattis.com/problems/zoning

## Personal Thoughts
Problem that I attempted during the summer holidays of 2020. Can be solved by using multi-source BFS with commercial zones as the sources and residential zones as the endpoints. Some observations:

1. If a zone has been visited before then we would not have to visit it again. There must have been a shorter path to it from another commercial zone (source), and hence a shorter path to any of the resulting residential zones (endpoints) which can be reached by the current path.
2. The above means that we can find the path from any residential zone to its closest commercial zone (the reverse path would have been explored by the BFS algorithm).
3. By storing the maximum path length encountered in observation 2, the resulting value is the distance which we want to find.

