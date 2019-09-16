# Link

https://open.kattis.com/problems/teque

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20.

Initial solution:
I used a custom ArrayDeque data structure which I coded while trying out the online version of UC Berkeley's CS61B. Two ArrayDeques were used to simulate the Teque and they were kept at around the same size throughout all push operations. The use of two ArrayDeques allows for all the required operations to be carried out in O(1) time.

Improved solution:
A single array can be used to store all the integers. The size of this array can be hard coded since we know the input's upper limit. We maintain two separate regions to simulate the front half and back half of the teque. These regions have to be balanced as new integers are added to the teque.

