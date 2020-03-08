# Link

https://open.kattis.com/problems/distinctivecharacter

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. Can be solved by running multi-source BFS and choosing the bitmask which is at the end of the BFS queue, i.e. the one furthest away from all of the given inputs. To find each neighbour (flip each digit) of the bitmask being polled from the queue, we iteratively XOR it with a bitmask containing 1 at a single position, and 0 elsewhere.

