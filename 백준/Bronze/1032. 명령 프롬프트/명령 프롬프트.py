n = int(input())

m = list(input())

arr = []
for i in range(n-1):
    arr.append(input())

for i in arr:
    for j in range(len(m)):
        if i[j] != m[j]:
            m[j] = '?'

m = ''.join(m)
print(m)
