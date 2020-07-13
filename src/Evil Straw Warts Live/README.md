# Link

https://open.kattis.com/problems/evilstraw

## Personal Thoughts
Problem that I attempted during the summer holidays of 2020.

Observation: A swap does not change the relative ordering of the rest of the characters. For example, in the string "mamad", let's say that we first want to match the two m's. Swapping the second pair of a and m to yield "maamd" does not change the relative ordering among the other characters (besides the current two m's which we care about). That is to say, the other characters are still in the order "aad" in both strings "mamad" (before the swap) and "maamd" (after the swap) if we ignore the two m's.

Thus, this problem can be solved by going through the string and pairing s[0] with the rightmost matching character and s[s.length - 1] with the leftmost matching character, then removing every such pair that is found. We go from both directions because the middle character may be at the left or rightmost position in an odd length palindrome, in which case a matching character cannot be found for it and the algorithm may terminate prematurely if we only perform the matchings from a single direction.

We do not actually have to swap any characters after performing a matching. Rather, we can remove both characters from the string and just count the number of positions that the out of place character is off by, and add that to the total count. This has the same effect of performing that number of swaps to get the misplaced character to its actual position.

