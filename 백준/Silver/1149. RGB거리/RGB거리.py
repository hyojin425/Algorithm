n = int(input()) # 집 개수
    
dp = list(map(int, input().split()))
for i in range(1, n):
    data = list(map(int, input().split()))
    data[0] += min(dp[1] ,dp[2])
    data[1] += min(dp[0], dp[2])
    data[2] += min(dp[0], dp[1])
    dp = data 
     
print(min(dp))