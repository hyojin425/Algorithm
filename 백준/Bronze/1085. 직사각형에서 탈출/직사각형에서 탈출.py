x, y, w, h = map(int, input().split())

xMin = 0
if x < w - x:
    xMin = x
else:
    xMin = w - x
    
yMin = 0
if y < h - y:
    yMin = y
else:
    yMin = h - y
    
print(min(xMin, yMin))