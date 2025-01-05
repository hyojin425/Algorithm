from collections import deque
import sys

n, m, v = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(n + 1):
    graph[i].sort()

def dfs(n): 
    print(n, end = ' ')
    visited[n] =True
    
    for i in graph[n]:
        if not visited[i]:
            dfs(i)
    
def bfs(n):
    visited[n] = True
    q = deque([n])
    
    while q:
        tmp = q.popleft()
        print(tmp, end = ' ')
        for i in graph[tmp]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
                
visited = [False for _ in range(n + 1)]
dfs(v)
print()
visited = [False for _ in range(n + 1)]
bfs(v)