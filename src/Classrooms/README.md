# Link

https://open.kattis.com/problems/classrooms

## Personal Thoughts

Problem that I attempted during the summer holidays of 2020. Can be solved by greedily choosing classrooms for each activity. Activities are sorted by increasing end time, and increasing start time if ties arise.

I initially used a priority queue to attempt this problem but this would not work because some intervals may be wasted. For instance, if the activiy times are given as [[1, 5], [6, 13], [3, 8], [10, 11]], then the priority queue approach would result [10, 11] taking up the classroom after [1, 5], and [6, 13] would not be scheduled since the other classroom is only available after time 8. However, we can clearly see that the optimal assignment is [1, 5], [6, 13] in one classroom, and [3, 8], [10, 11] in another. Hence, the priority queue approach does not work.

