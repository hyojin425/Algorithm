import sys
from collections import deque

def bfs(v):
    visited = [False] * n
    queue = deque([[v, 0]])
    visited[v] = True
    cnt = 0
    while queue:
        a, b = queue.popleft()
        if b >= 2:
            continue
        for i in range(n):
            if not visited[i] and graph[a][i] == "Y":
                cnt += 1
                visited[i] = True
                queue.append([i, b + 1])
    return cnt


n = int(sys.stdin.readline())
graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(n)]

res = 0
for i in range(n):
    res = max(res, bfs(i))

print(res)