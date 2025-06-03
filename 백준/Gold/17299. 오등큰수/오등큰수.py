n = int(input())
arr = list(map(int, input().split()))
max_val = max(arr)
F = [0] * (max_val + 1)

for i in arr:
    F[i] += 1
    
stack = []
stack.append(0)
answer = [-1] * n
for i in range(1, n):
    while stack and F[arr[stack[-1]]] < F[arr[i]]:
        answer[stack.pop()] = arr[i]
    stack.append(i)
    
print(*answer)