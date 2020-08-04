import sys

for line in sys.stdin:
    numbers = line.split(" ")
    k = int(numbers[0]) + 1
    n = int(numbers[1]) + 1

    dpTable = [[0 for x in range(k)] for y in range(n)]

    for i in range(k):
        dpTable[1][i] = 1

    # Bottom-up DP
    for i in range(2, n):
        for j in range(k):
            for l in range(-1, 2):

                # Add previous number of tight words to current position in DP table
                if j + l >= 0 and j + l < k:
                    dpTable[i][j] += dpTable[i - 1][j + l]

    total = 0
    for i in range(k):
        total += dpTable[n - 1][i]

    print(str(100 * total / (k) ** (n - 1)))
