n = int(input())
stack, result  = [], []
find = True
cnt = 1

for _ in range(n):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        result.append("+")
        cnt += 1
    if stack[-1] == num:
        stack.pop()
        result.append("-")
    else:
        find = False

if find:
    for r in result:
        print(r)
else:
    print("NO")