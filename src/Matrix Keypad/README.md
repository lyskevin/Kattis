# Link

https://open.kattis.com/problems/keypad

## Personal Thoughts

Problem that I attempted during the summer break of AY20/21. The problem can be approached as follows:

1. Use all the 1s in the grid to determine which rows and columns are activated. A 1 at position `(i, j)` means that row `i` and column `j` must definitely be activated.
2. Set all positions in the result matrix to `N`. We will write code to check for `I`, `P`, in which case the appropriate position in the result matrix will be changed, or an impossible state, in which case we print the appropriate output.
3. Iterate over the input grid. For each position `(i, j)`, check if row `i` and column `j` are both activated. If so, there are 3 possible scenarios:
    * The element at position `(i, j)` in the grid is 0. Clearly, this state is impossible to reach since row `i` and column `j` are both activated.
    * The element at position `(i, j)` in the grid is 1 and only one row or one column is activated. Suppose that only one row is activated (i.e. only row `i` is activated). This means that the button at position `(i, j)` must be pressed as it is the only button in row `i` that activates column `j`, and we know that only buttons in row `i` can be pressed since only row `i` is activated. We can make a similar argument if only column `j` is activated. Hence, position `(i, j)` in the result matrix should be `P`.
    * The element at position `(i, j)` in the grid is 1 and more than one row and more than one column are activated. In this case, row `i` and column `j` could be activated by different buttons without the need for the button at `(i, j)`, so position `(i, j)` in the result matrix should be `I`.

