

# 단어에서 문자가 홀수개인 것이 2개 이상이라면 성립되지 않는다.
# 문자열을 정렬해야함

import collections
import sys

word = sys.stdin.readline().rstrip()
check = collections.Counter(word)

cnt = 0
mid = ''
for s, n in list(check.items()):
    if n % 2 != 0:
        cnt += 1
        mid = s
        if cnt >= 2 :
            print("I'm Sorry Hansoo")
            exit()
        
result = ""
for s, n in sorted(check.items()):
    while n > 1:
        result += s
        n -= 2
        

print(result + mid + result[::-1])
    