
import sys

input = sys.stdin.readline

n = int(input())
l = list(input())

sum = 0
for i in range(len(l) - 1):
    sum += int(l[i])
print(sum)