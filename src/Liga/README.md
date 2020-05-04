# Link

https://open.kattis.com/problems/liga

## Personal Thoughts

Problem that I attempted while I was a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 2 of AY19/20. We model the problem using the given information (games (G), wins (W), draws (D), losses (L), points (P)). We observe that W + D + L = N and 3W + D = P. Furthermore, at least one of  G, W, D, L must be known to uniquely determine the values in each field, because each L gives 0 points. Using these constraints, we can then use two nested loops to iterate over possible values of two of W, D, L. If we find values that match all of the above constraints, we can then use them to generate the rest of the unknown values, if any. 

