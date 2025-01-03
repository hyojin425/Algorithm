from itertools import combinations
import sys

n, m = map(int, input().split())

chicken = []
city = []
for i in range(n):
    data = list(map(int, input().split()))
    city.append(data)
    for j in range(n):
        if data[j] == 2: chicken.append((i, j))
        
combi = list(combinations(chicken, m))

def cal(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

result = sys.maxsize
for c in combi:
    s = 0
    for i in range(n):
        for j in range(n):
            if city[i][j] == 1:
                home = sys.maxsize
                for d in c :
                    home = min(home, cal((i, j), d))
                s += home
    
    result = min(s, result)     

print(result)