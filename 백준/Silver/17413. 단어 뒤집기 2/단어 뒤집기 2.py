import sys
str = sys.stdin.readline().strip() + ' '

result = ""
flag = False
stack = []
for i in str:
    if i == '<':
        flag = True
        for _ in range(len(stack)):
            result += stack.pop()
    stack.append(i)
    if i == '>':
        flag = False
        for _ in range(len(stack)):
            result += stack.pop(0)
    if i == ' ' and flag == False:
        stack.pop()
        for _ in range(len(stack)):
            result += stack.pop()
        result += ' '
print(result)