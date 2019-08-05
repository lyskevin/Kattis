# Link

https://open.kattis.com/problems/dominoes2

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. I modelled this as a graph problem with the dominoes as vertices and connections as edges. I then used a multi-source DFS algorithm to count the number of fallen dominoes; every domino which the DFS algorithm visits based on a given source domino is counted as a fallen domino. A boolean array is used to keep track of dominoes which have already fallen so that they are not counted again during subsequent runs of the DFS algorithm.

