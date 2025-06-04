n = int(input())
s = input()
arr = [0] * n
for i in range(n):
    arr[i] = int(input())
    
stack = []

for i in s:
    if 'A' <= i <= 'Z':
        stack.append(arr[ord(i) - 65])
    else:
        a = stack.pop()
        b = stack.pop()
        
        if i == '+':
            stack.append(b + a)
        elif i == '-':
            stack.append(b - a)
        elif i == '*':
            stack.append(b * a)
        elif i == '/':
            stack.append(b / a)
        
print(f"{stack.pop():.2f}")