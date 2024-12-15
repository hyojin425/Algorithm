def fibonacci(n) :
    cnt0 = [1, 0]  
    cnt1 = [0, 1] 
    if n == 0:
        return f"{cnt0[0]} {cnt1[0]}"
    elif n == 1:
        return f"{cnt0[1]} {cnt1[1]}"
    else:
        while len(cnt0) <= n:
            cnt0.append(cnt0[-1] + cnt0[-2])
            cnt1.append(cnt1[-1] + cnt1[-2])

            
    return f"{cnt0[n]} {cnt1[n]}"

n = int(input())
for _ in range(n):
    m = int(input())
    print(fibonacci(m))