## Analysis
- 수동으로 곱셈하는 방법을 사용
    - 해당 위치에 각 숫자의 곱과 합을 구함
```
s1 = 123
s2 = 456

d[] = new int[6] // 3자리 * 3자리이기 때문

r1 = reverse(s1) = 321
r2 = reverse(s2) = 654

for i = 0 to 2:
    for j = 0 to 2:
        d[i + j] += r1[i] * r2[j]

i = 0, j = 0: 3 * 6 = 18
i = 0, j = 1: 3 * 5 = 15
i = 0, j = 2: 3 * 4 = 12

```
|d[0]|d[1]|d[2]|d[3]|d[4]|d[5]|
|----|----|----|----|----|----|
|18|15|12|0|0|0|
```
i = 1, j = 0: 2 * 6 = 12
i = 1, j = 1: 2 * 5 = 10
i = 1, j = 2: 2 * 4 = 8
```                           
|d[0]|d[1]|d[2]|d[3]|d[4]|d[5]|
|----|----|----|----|----|----|
|18|27|22|8|0|0|
```
i = 2, j = 0: 1 * 6 = 6
i = 2, j = 1: 1 * 5 = 5
i = 2, j = 2: 1 * 4 = 4
```
|d[0]|d[1]|d[2]|d[3]|d[4]|d[5]|
|----|----|----|----|----|----|
|18|27|28|13|4|0|

```
d 배열을 탐색하면서 자릿수를 올려주면서 앞에서부터 더해줌

d[0]은 18이므로 10은 다음 자릿수에서 1을 더해주면 되므로 d[1] += 1,
원래 1의 자리 수 이므로 맨 뒷자리에 나머지를 더해주면 8

d[1]은 28(앞에서 1이 더해짐), 다음 자릿수에 2를 더해줌 d[2] += 2,
원래 10의 자리 수 이므로 1의 자리 수보다 앞에 추가해주면 88

d[2]는 30(앞에서 2가 더해짐), 다음 자릿수에 3을 더해줌 d[3] += 3,
원래 100의 자리 수 이므로 가장 앞에 더해주면 088

d[3]: 16, d[4] += 1, 6088
d[4]: 5, 56088
d[5]: 0, 056088

맨 앞에 0이 있으면 제거
```