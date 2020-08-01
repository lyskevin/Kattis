numbers = input().split()
N = int(numbers[0])
K = int(numbers[1])

# log2(10) == 3.32... => log2(10^101) == 101 * log2(10) ~= 336 (rounded up)
if K >= 336 or 1 << K >= N:
    print("Your wish is granted!")
else:
    print("You will become a flying monkey!")

