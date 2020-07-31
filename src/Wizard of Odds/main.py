numbers = input().split()
N = int(numbers[0])
K = int(numbers[1])

if K >= 336 or 1 << K >= N:
    print("Your wish is granted!")
else:
    print("You will become a flying monkey!")

