n = int(input())

list = []
for _ in range(n):
    str = input()
    numbers = [int(num) for num in str if num.isdigit()]
    data = [str, len(str), sum(numbers)]
    list.append(data)
    
for i in range(n):
    for j in range(i + 1, n):
        if list[i][1] > list[j][1]:
            tmp = list[i]
            list[i] = list[j]
            list[j] = tmp
        elif list[i][1] == list[j][1] and list[i][2] > list[j][2]:
            tmp = list[i]
            list[i] = list[j]
            list[j] = tmp
        elif list[i][1] == list[j][1] and list[i][2] == list[j][2] and list[i][0] > list[j][0]:
            tmp = list[i]
            list[i] = list[j]
            list[j] = tmp
            
for i in range(n):
    print(list[i][0])