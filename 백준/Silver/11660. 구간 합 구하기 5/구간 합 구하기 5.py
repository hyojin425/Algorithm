import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = [list(map(int, input().split())) for _ in range(n)]
sums = [[0] * (n + 1) for _ in range(n + 1)]

sums[1][1] = nums[0][0]
for i in range(2, n + 1):
    sums[1][i] = sums[1][i - 1] + nums[0][i - 1]
    sums[i][1] = sums[i - 1][1] + nums[i - 1][0]
    
for i in range(1, n + 1):
    for j in range(1, n + 1):
        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + nums[i - 1][j - 1]
        
for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    result = sums[x2][y2] - sums[x1 - 1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1]
            
    print(result)