def dfs(n):
    if n == 1 :
         return ["*"]
    stars = dfs(n//3)
    l = []
    
    for s in stars:
        l.append(s*3)
    for s in stars:
        l.append(s+" "*(n//3)+s)
    for s in stars:
        l.append(s*3)
    return l

m = int(input())
print('\n'.join(dfs(m)))