n, r, c = map(int, input().split())

def dfs(r, c, size, n):
    size = size // 2
    if r < size and c < size:
        if size == 1:
            print(n)
            exit()
        dfs(r, c, size, n)
    elif r < size and c >= size:
        if size == 1:
            print(n + 1)
            exit()
        dfs(r, c - size, size, n + size ** 2)
    elif r >= size and c < size:
        if size == 1:
            print(n + 2)
            exit()
        dfs(r - size, c, size, n + (size ** 2) * 2)
    elif r >= size and c >= size:
        if size == 1:
            print(n + 3)
            exit()
        dfs(r - size, c - size, size, n + (size ** 2) * 3)
    
        

dfs(r, c, 2 ** n, 0)


