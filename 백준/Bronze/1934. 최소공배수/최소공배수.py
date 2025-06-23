n = int(input())

def gcd(a, b):
    while b > 0:
        tmp = b
        b = a % b
        a = tmp
    return a

for i in range(n):
    a, b = map(int, input().split())
    print(int((a * b) / gcd(a, b)))
    


