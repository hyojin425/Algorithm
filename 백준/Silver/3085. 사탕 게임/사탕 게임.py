n = int(input())
board = [list(input()) for _ in range(n)]

dx = [1, 0]
dy = [0, -1]

def check():
    max_count = 0
    for i in range(n):
        cnt1 = 1
        for j in range(1, n):
            if board[i][j] == board[i][j-1]:
                cnt1 += 1
            else:
                cnt1 = 1
            max_count = max(cnt1, max_count)
        cnt2 = 1
        for j in range(1, n):
            if board[j][i] == board[j-1][i]:
                cnt2 += 1
            else:
                cnt2 = 1
            max_count = max(cnt2, max_count)
                
    return max_count

result = 0
for i in range(n):
    for j in range(n):
        for k in range(2):
            nx = i + dx[k]
            ny = j + dy[k]
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] != board[i][j]:
                board[i][j], board[nx][ny] = board[nx][ny], board[i][j]
                result = max(result, check())
                board[i][j], board[nx][ny] = board[nx][ny], board[i][j]
print(result)