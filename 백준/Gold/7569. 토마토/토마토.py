from sys import stdin 
from collections import deque

m, n, h = map(int, stdin.readline().split())
box = []
for _ in range(h):
    b = []
    for _ in range(n):
        b.append(list(map(int, stdin.readline().split())))
    box.append(b)
       
dx = [-1, 0, 1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dh = [0, 0, 0, 0, 1, -1]

Q = deque()
for k in range(h):
    for i in range(n):
        for j in range(m):
            if box[k][i][j] == 1:
                Q.append((k, i, j))
                
while Q:
    tmp = Q.popleft()
    for i in range(6):
        nh = tmp[0] + dh[i]
        nx = tmp[1] + dx[i]
        ny = tmp[2] + dy[i]
        if 0<= nh < h and 0<= nx < n and 0<= ny < m and box[nh][nx][ny] == 0:
           Q.append((nh, nx, ny))
           box[nh][nx][ny] = box[tmp[0]][tmp[1]][tmp[2]] + 1
    
day = 0
for k in range(h):
    for i in range(n):
        for j in range(m):
            if box[k][i][j] == 0:
                print(-1)
                exit(0)
            day = max(day, box[k][i][j])
print(day - 1)