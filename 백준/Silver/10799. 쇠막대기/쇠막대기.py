    
command = input()

stack = []
result = 0
for i in range(len(command)):
    if command[i] == "(":
        stack.append("(")
    else:
        if command[i - 1] == "(":
            stack.pop()
            result += len(stack)
        else:
            stack.pop()
            result += 1
        
print(result)