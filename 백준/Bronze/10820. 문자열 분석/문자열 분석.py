while True:
    try:
        s = input()
        answer = [0] * 4
        for i in s:
            if 'a' <= i <= 'z':
                answer[0] += 1
            elif 'A' <= i <= 'Z':
                answer[1] += 1
            elif '0' <= i <= '9':
                answer[2] += 1
            elif i == ' ':
                answer[3] += 1
        print(*answer)
    except EOFError:
        exit()