import ast
from collections import deque
import re

n = int(input())

def solution(command, m, lst):
    queue = deque(lst)
    is_reversed = False
    
    for c in command:
        if c == 'R':
            is_reversed = not is_reversed
        elif c == 'D':
            if queue:
                if is_reversed:
                    queue.pop()
                else:
                    queue.popleft()
            else:
                return "error"
            
    if is_reversed:
        queue.reverse()
        
    return list(queue)

for _ in range(n):
    commands = input()
    m = int(input())
    lst = ast.literal_eval(input())
    result = solution(commands, m, lst)
    if result == "error":
        print("error")
    else:
        print(str(result).replace(" ", ""))