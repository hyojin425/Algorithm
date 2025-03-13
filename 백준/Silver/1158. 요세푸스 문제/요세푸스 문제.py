import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())

q = deque()
for i in range(1, n + 1):
    q.append(i)
    
result = []
cnt = 1
while q:
    if cnt == m:
        result.append(q.popleft())
        cnt = 1
    else:
        q.append(q.popleft())
        cnt += 1
      
print(f"<{', '.join(map(str, result))}>")