s = input()

answer = ""

for i in s:
    if 'A' <= i <= 'Z':
        answer += chr((ord(i) - 65 + 13) % 26 + 65)
    elif 'a' <= i <= 'z':
        answer += chr((ord(i) - 97 + 13) % 26 + 97)
    else:
        answer += i
    
print(answer)