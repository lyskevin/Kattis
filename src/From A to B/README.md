# Link

https://open.kattis.com/problems/fromatob

## Personal Thoughts

Problem that I attempted during the summer break of AY20/21. One observation is that A can only increase when one is added and decrease when halved. This results in the following scenarios:

1. A == B: Stop here.
2. A < B: The remaining number of steps is just the difference between B and A. We can calculate this immediately instead of manually adding one, which will give a TLE verdict.
3. A > B and A is even: Halve A.
4. A > B and A is odd: Add one to A (Halve A in the next step).

