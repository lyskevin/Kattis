# Link

https://open.kattis.com/problems/astro

## Personal Thoughts

Problem that I attempted during my winter break in 2019. Can be solved by using a large boolean array to track flash timings. I initially used a boolean array of size 10080 (1440 * 7; the number of minutes in a week) with looping, but this did not work because flashes could be a week apart (so not actually the same time) but still be recorded as having happened at the same time.

