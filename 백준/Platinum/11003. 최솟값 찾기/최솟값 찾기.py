import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))
q = deque()

minV = nums[0]
for i in range(n):
    while q and q[-1][0] > nums[i]:
        q.pop()
    q.append((nums[i], i))
    if q[0][1] <= i - m:
        q.popleft()
    print(q[0][0], end = ' ')