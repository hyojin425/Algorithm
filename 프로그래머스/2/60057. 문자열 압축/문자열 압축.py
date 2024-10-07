def solution(s):
    answer = len(s)
    l = len(s)
    for i in range(1, l//2 + 1):
        compressed = ""
        repeat = s[0:i]
        cnt = 1
        for j in range(i, l, i):
            if repeat == s[j: j + i]:
                cnt += 1
            else:
                if cnt == 1:
                    compressed += repeat
                else:
                    compressed += str(cnt) + repeat
                repeat = s[j: j + i]  
                cnt = 1
            
        if cnt == 1:
            compressed += repeat
        else:
            compressed += str(cnt) + repeat 
        answer = min(answer , len(compressed))
    return answer