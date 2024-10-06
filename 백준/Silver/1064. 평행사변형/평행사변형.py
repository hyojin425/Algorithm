ax, ay, bx, by, cx, cy = map(int, input().split())

if (ax - bx) * (ay - cy) == (ay - by) * (ax - cx):
    print(-1.0)
else:
    len1 = ((ax-bx)**2 + (ay-by)**2)**0.5  # a와 b의 길이
    len2 = ((ax-cx)**2 + (ay-cy)**2)**0.5  # a와 c의 길이
    len3 = ((cx-bx)**2 + (cy-by)**2)**0.5  # b와 c의 길이
    
    lenList = [len1 + len2, len1 + len3, len2 + len3]
    min = min(lenList)
    max = max(lenList)
    print(2 * (max - min))