import heapq
import sys

input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    
a, b = map(int, input().split())
dis = [1e9 for _ in range(n + 1)]
dis[a] = 0  
q = []
heapq.heappush(q, [a, 0]) 

while q:
    node, cost = heapq.heappop(q)
    if dis[node] < cost:
        continue
    for n, c in graph[node]:
        nCost = dis[node] + c
        if nCost >= dis[n]:
            continue
        
        dis[n] = nCost
        heapq.heappush(q, [n, nCost])
            
print(dis[b])