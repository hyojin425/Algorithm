n = int(input())
arr = list(map(int, input().split()))

arr.sort()

if n == 1:
    print(arr[0] * arr[0])
else :
    result = max(arr)
    for i in range(n+1):
        result *= arr[i]
        flag = True
        for j in arr:
            if result % j != 0: 
                flag = False
            
        if flag == True: 
            print(result)
            break



