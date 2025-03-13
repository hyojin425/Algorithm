import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())    
    
def dfs(v, arr, visited):
    visited[v] = 1
    for i in arr[v]:
        if visited[i] == 0:
            dfs(i, arr, visited)
  
result = 0              
arr = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)
    
for i in range(1, n + 1):
    if visited[i] == 0:
        dfs(i, arr, visited)
        result += 1
    
print(result)
