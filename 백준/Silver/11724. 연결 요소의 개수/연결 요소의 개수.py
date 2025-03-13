import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())    
    
def bfs(start, arr, visited):
    q = deque([start])
    visited[start] = 1
    
    while q:
        v = q.popleft()
        for i in arr[v]:
            if visited[i] != 1:
                q.append(i)
                visited[i] = 1
  
result = 0              
arr = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
    
for i in range(1, n + 1):
    if visited[i] != 1:
        bfs(i, arr, visited)
        result += 1
    
print(result)
