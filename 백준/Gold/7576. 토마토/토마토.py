from sys import stdin 
from collections import deque

m, n = map(int, stdin.readline().split())
box = []
for _ in range(n):
    box.append(list(map(int, stdin.readline().split())))
       
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

Q = deque()
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            Q.append((i,j))

day = [[0 for _ in range(m)] for _ in range(n)]
while Q:
    tmp = Q.popleft()
    for i in range(4):
        nx = tmp[0] + dx[i]
        ny = tmp[1] + dy[i]
        if 0<= nx < n and 0<= ny < m and box[nx][ny] == 0:
           Q.append((nx,ny))
           box[nx][ny] = box[tmp[0]][tmp[1]] + 1
    
day = 0
for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            print(-1)
            exit(0)
        day = max(day, box[i][j])
print(day - 1)