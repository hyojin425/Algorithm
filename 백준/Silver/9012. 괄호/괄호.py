import sys
from collections import deque
input = sys.stdin.readline
    
def check(command):
    stack = []
    for c in command:
        if c == '(':
            stack.append(c)
        elif c == ')':
            if stack:
                stack.pop()
            else:
                print("NO")
                return
    if stack:
        print("NO")
    else:
        print("YES")
    
        
n = int(input())
for _ in range(n):
    command = list(input())
    check(command)