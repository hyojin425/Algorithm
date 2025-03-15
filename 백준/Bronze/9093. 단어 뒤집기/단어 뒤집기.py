import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    arr = list(list(input().split()))
    for a in arr:
        print(''.join(reversed(a)), end = " ")
        
    print("")
