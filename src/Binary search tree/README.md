# Link

https://open.kattis.com/problems/bst

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. The most obvious solution is to use a custom BST class but this would probably result in a TLE verdict for test cases which are skewed towards one side of the BST since they have a time complexity of O(N<sup>2</sup>). Another potential solution is to build the binary search tree recursively but this would most likely result in an MLE verdict due to the maximum recursion depth being reached for large inputs. Given the upper bound of 300,000 integers, I finally thought of an O(Nlog(N)) solution involving a TreeMap which maps numbers to their respective depths in the simulated BST.
 
