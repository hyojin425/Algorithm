from sys import stdin 

n, m = map(int, stdin.readline().split())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, stdin.readline().strip())))
       
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
dis = [[0 for _ in range(m)] for _ in range(n)]

dis[0][0] = 1
q = [(0,0)]
matrix[0][0] = 0
while q:
    tmp = q.pop(0)
    for i in range(4):
        nx = tmp[0] + dx[i]
        ny = tmp[1] + dy[i]
        if 0 <= nx < n and 0<= ny < m and matrix[nx][ny] == 1:
            q.append((nx,ny))
            matrix[nx][ny] = 0
            dis[nx][ny] = dis[tmp[0]][tmp[1]] + 1
            
print(dis[n - 1][m - 1])