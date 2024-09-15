n = int(input())
f = int(input())


n = n // 100 * 100
for i in range(100):
    if n % f == 0:
        print(str(n)[-2:])
        break
    else:
        n += 1
