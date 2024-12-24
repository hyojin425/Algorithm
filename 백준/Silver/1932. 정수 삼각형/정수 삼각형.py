n = int(input())
tree = []
for _ in range(n):
    tree.append(list(map(int, input().split())))
    
for i in range(1, n):
    for j in range(len(tree[i])):
        if j == 0:
            tree[i][j] += tree[i - 1][j]
        elif j == len(tree[i]) - 1:
            tree[i][j] += tree[i - 1][j - 1]
        else:
            tree[i][j] += max(tree[i - 1][j - 1], tree[i - 1][j])
    
print(max(tree[n - 1]))