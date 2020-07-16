modValue = 1000000007

# u(n) = ((9 ^ (n - 1)) * 8) % 1000000007
def u(n):
    return (pow(9, n - 1, modValue) * (8 % modValue)) % modValue

T = int(input())

for i in range(T):
    print(str(u(int(input()))))

