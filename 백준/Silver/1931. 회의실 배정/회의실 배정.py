from sys import stdin
n = int(stdin.readline())
list = []
for i in range(n):
    start, end = map(int, stdin.readline().split())
    list.append((start, end))
    
data = sorted(list, key = lambda x: (x[0], x[1]))

end = data[0][1]
cnt = 1
for i in range(1, n):
    if data[i][0] >= end:
        cnt += 1
        end = data[i][1]
    elif data[i][1] < end:
        end = data[i][1]
        
print(cnt)