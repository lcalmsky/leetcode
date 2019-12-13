## Analysis

- 양쪽 끝에서 스캔하면서 합을 구하는 방법을 사용

```
[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
                      ▢
              ▢       ▢ ▢   ▢
        __▢___▢_▢___▢_▢_▢_▢_▢_▢_
left -> 0 1 1 2 2 2 2 3 3 3 3 3
        3 3 3 3 3 3 3 3 2 2 2 1  <- right
        ^
        i
         
min[i] = Math.min(left[i], right[i]);
i=1  : min[1]  = Math.min(0, 3) = 0
i=2  : min[2]  = Math.min(1, 3) = 1
i=3  : min[3]  = Math.min(1, 3) = 1
i=4  : min[4]  = Math.min(2, 3) = 2
i=5  : min[5]  = Math.min(2, 3) = 2
i=6  : min[6]  = Math.min(2, 3) = 2
i=7  : min[7]  = Math.min(2, 3) = 2
i=8  : min[8]  = Math.min(3, 3) = 3
i=9  : min[9]  = Math.min(3, 2) = 2
i=10 : min[10] = Math.min(3, 2) = 2
i=11 : min[11] = Math.min(3, 2) = 2
i=12 : min[12] = Math.min(3, 1) = 1

sum += min[i] - height[i]
i=1  : 0 - 0 = 0 : sum = 0
i=2  : 1 - 1 = 0 : sum = 0
i=3  : 1 - 0 = 1 : sum = 1
i=4  : 2 - 2 = 0 : sum = 0
i=5  : 2 - 1 = 1 : sum = 2
i=6  : 2 - 0 = 2 : sum = 4
i=7  : 2 - 1 = 1 : sum = 5
i=8  : 3 - 3 = 0 : sum = 0
i=9  : 2 - 2 = 0 : sum = 0
i=10 : 2 - 1 = 1 : sum = 6
i=11 : 2 - 2 = 0 : sum = 0
i=12 : 1 - 1 = 0 : sum = 0
``` 