import sys
from collections import deque
input = sys.stdin.readline
    
n = int(input())

arr = []
for i in range(n):
    arr.append(int(input()))
    
cnt = 1
stack = []
result = []
for a in arr:
    while cnt <= a:
        result.append("+")
        stack.append(cnt)
        cnt += 1
        
    if stack.pop() == a:
        result.append("-")
    else:
        print("NO")
        exit()

for r in result:
    print(r)
    
