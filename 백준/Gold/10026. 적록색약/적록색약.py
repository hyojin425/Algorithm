from collections import deque

n = int(input())
data = [list(input()) for _ in range(n)]
q = deque()

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]    

def bfs(i, j):
    cnt = 0
    q.append((i, j))
    visited[i][j] = 1   
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and data[nx][ny] == data[x][y] and visited[nx][ny] != 1:
                visited[nx][ny] = 1
                q.append((nx, ny))
                
# 적록색약 아닌 경우
cnt1 = 0
visited = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            bfs(i, j)
            cnt1 += 1
        
# 적록색약인 경우
for i in range(n):
    for j in range(n):
        if data[i][j] == 'G': data[i][j] = 'R'
        
cnt2 = 0
visited = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            bfs(i, j)
            cnt2 += 1
        
print(cnt1, cnt2)