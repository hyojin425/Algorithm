import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))

sum = 0
c = [0] * m

for i in range(n):
    sum += nums[i]
    remain = sum % m
    c[remain] += 1
 
result = c[0]
   
for i in range(m): 
    if c[i] > 1:
        result += (c[i] * (c[i] - 1) // 2)
        
print(result)