## Analysis
Dynamic Programming 기법을 이용하여 구간 내 가장 큰 값을 구한다.

- n번째 배열의 합은 기존까지의 합 + 현재 값
- 기존까지의 합이 마이너스인 경우 현재부터 새로운 부분 배열 시작

```
input: -2, 1, -3, 4, -1, 2, 1, -5, 4

dp[0]: 0 // 한 개도 선택하지 않은 경우
dp[1]: -2 // input 배열의 첫 번 째 값까지 더한 경우

dp[n] = Math.max(dp[n-1], 0) + input[n-1]

dp[2] = Math.max(-2, 0) + 1 = 1 // 부분 배열 새로 시작
dp[3] = Math.max(1, 0) - 3 = -2
dp[4] = Math.max(-2, 0) + 4 = 4 // 새로 시작
dp[5] = Math.max(4, 0) - 1 = 3
dp[6] = Math.max(3, 0) + 2 = 5
dp[7] = Math.max(5, 0) + 1 = 6 << max
dp[8] = Math.max(6, 0) - 5 = 1
dp[9] = Math.max(1, 0) + 4 = 5
```