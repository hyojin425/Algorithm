from collections import deque
t = int(input())

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

def bfs(graph, x, y, m, n):
    q = deque()
    q.append([x, y])
    graph[x][y] = 0
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 1:
                q.append([nx,ny])
                graph[nx][ny] = 0

for _ in range(t):
    m, n, l = map(int, input().split())
    graph = [[0] * n for _ in range(m)]
    for _ in range(l):
        x, y = map(int, input().split())
        graph[x][y] = 1
        
    cnt = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                bfs(graph, i, j, m , n)
                cnt += 1
                
    print(cnt)
    