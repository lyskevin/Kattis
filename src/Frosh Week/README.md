# Link

https://open.kattis.com/problems/froshweek

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. An O(N<sup>2</sup>) solution would not work here since there can be up to 1M entries. I initially implemented a custom comparator and used Java's Arrays.sort() method which runs in O(N log N) time. I then summed the relative differences between a numbers initial and final positions, and divided this sum by 2 to get the number of swaps. However, this produced the wrong answer for the second test case. I subsequently learnt about counting inversions and implemented a modified merge sort to do so, which is the correct way to approach this problem.

