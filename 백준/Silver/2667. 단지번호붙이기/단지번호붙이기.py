from sys import stdin 

n = int(stdin.readline())
matrix = []
for _ in range(n):
    matrix.append(list(map(int, stdin.readline().strip())))
       
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

q = []
total = 0
result = []
for i in range(n):
    for j in range(n):
        if matrix[i][j] == 1:
            total += 1
            q.append((i,j))
            matrix[i][j] = 0
            cnt = 1
            while q:
                tmp = q.pop(0)
                for k in range(4):
                    nx = tmp[0] + dx[k]
                    ny = tmp[1] + dy[k]
                    if 0<= nx < n and 0<= ny < n and matrix[nx][ny] == 1:
                        q.append((nx,ny))
                        cnt += 1
                        matrix[nx][ny] = 0
            result.append(cnt)
                        
print(total)
result.sort()
for i in range(total):
    print(result[i])