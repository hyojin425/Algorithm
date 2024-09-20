a, b = input().split()

size = len(b) - len(a) + 1
result = 1e9
for i in range(size):
    tmp = 0
    for j in range(len(a)):
        if a[j] != b[j + i]:
            tmp += 1
            
    if tmp < result:
        result = tmp
    
print(result)
            
    