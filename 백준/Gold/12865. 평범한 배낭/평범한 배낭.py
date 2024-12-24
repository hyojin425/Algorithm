n, k = map(int, input().split())
dy = [0 for _ in range(k + 1)]
for _ in range(n):
    w, v = map(int, input().split())
    for i in range(k, w - 1, -1):
        dy[i] = max(dy[i], dy[i - w] + v)
print(max(dy))