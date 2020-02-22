# Link

https://open.kattis.com/problems/gcpc

## Personal Thoughts

Problem that I attempted while preparing to become a Teaching Assistant (TA) for NUS' CS2040 (Data Structures and Algorithms) course in Semester 1 of AY19/20. This was probably the most difficult problem for me to solve, not in terms of absolute difficulty but due to my own carelessness and the number of bugs in my code. For starters, I modified the code that I submitted for CS2040's Data Structures Challenge (which was itself modified from some given skeleton code). This resulted in quite a few bugs, the most significant of which came from using a custom reference type (the Score class) instead of a primitive type (the original skeleton code used int) as BST keys. The code became very tricky to implement due to this new layer of referencing, especially for the deletion operation involving a node with two children. Furthermore, the existence of duplicates meant that I had to keep track of a duplicate counter at each node. I (initially) did not realise that this would result in the wrong size attribute being given when performing the rank operation, as well as when updating the size for each node.  Overall this was a lesson well learnt in careful planning and debugging. I should not expect my code to be robust if I take a half-hearted approach towards modifying code that already exists as well as taking reference types for granted.

