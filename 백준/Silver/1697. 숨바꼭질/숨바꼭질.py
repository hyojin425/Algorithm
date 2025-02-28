import sys
from collections import deque

n ,m = map(int, input().split())
q = deque([n])
visited = set([n])
result = 0

while q:
    l = len(q)
    for i in range(l):
        tmp = q.popleft()
        if tmp == m:
            print(result)
            exit()
        for next in (tmp + 1, tmp - 1, tmp * 2):
            if 0 <= next <= 100000 and next not in visited: 
                q.append(next)
                visited.add(next)
    result += 1
        
        
            
            