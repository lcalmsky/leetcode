# 풀이

```java
List<int[]>all=new ArrayList<>();
        for(int[]rectangle:rectangles)helper(all,rectangle,0);
```

모든 직사각형을 첫 번 째 직사각형부터 순차적으로 비교합니다.

```java
private void helper(List<int[]>all,int[]current,int start){
        if(start>=all.size()){
        all.add(current);
        return;
        }
// ...
```

직사각형을 담을 리스트의 크기와 비교할 인덱스가 동일할 경우 현재 직사각형을 리스트에 추가하고 메서드를 종료합니다. 즉, 첫 번 째로 추가 된 직사각형의 경우 바로 리스트에 추가됩니다. 위의 부분을 제외한 나머지
부분이 수행되지 않는다고 가정하면 자기 자신과 비교하게 될 때 리스트에 추가됩니다.

예제로 주어진 직사각형 배열을 살펴보면

```
{0, 0, 2, 2}
{1, 0, 2, 3}
{1, 0, 3, 1}
```

이 중 `{0, 0, 2, 2}`가 리스트에 추가되고 `foreach` 문의 다음 `iteration`이 수행됩니다.

두 번 째 직사각형인 `{1, 0, 2, 3}`를 비교할 때는 리스트에 이미 추가된 0번째 인덱스인 첫 번 째 직사각형과 비교합니다.

```java    
    // ...
    int[] rectangle = all.get(start);
    if (current[RIGHT] <= rectangle[LEFT] || current[BOTTOM] <= rectangle[TOP] || current[LEFT] >= rectangle[RIGHT] || current[TOP] >= rectangle[BOTTOM]) {
        helper(all, current, start + 1);
        return;
    }
    if (current[LEFT] < rectangle[LEFT])
        helper(all, new int[]{current[LEFT], current[TOP], rectangle[LEFT], current[BOTTOM]}, start + 1);
    if (current[RIGHT] > rectangle[RIGHT])
        helper(all, new int[]{rectangle[RIGHT], current[TOP], current[RIGHT], current[BOTTOM]}, start + 1);
    if (current[TOP] < rectangle[TOP])
        helper(all, new int[]{Math.max(rectangle[LEFT], current[LEFT]), current[TOP], Math.min(rectangle[RIGHT], current[RIGHT]), rectangle[TOP]}, start + 1);
    if (current[BOTTOM] > rectangle[BOTTOM])
        helper(all, new int[]{Math.max(rectangle[LEFT], current[LEFT]), rectangle[BOTTOM], Math.min(rectangle[RIGHT], current[RIGHT]), current[BOTTOM]}, start + 1);
}
```

여기부터는 아래 규칙을 따릅니다.

현재 전달된 직사각형과 이미 리스트에 추가된 직사각형을 비교하면서

1. 현재 직사각형이 이미 추가된 직사각형과 겹치지 않을 경우 다음 직사각형과의 비교를 위해 index 값을 올려준 뒤 재귀호출 합니다.
2. 1번에 해당하지 않는 경우 한 군데라도 겹치는 부분이 있다는 것 이므로 겹치는 부분을 제외한 직사각형 만듧니다.
    1. 현재 직사각형의 왼쪽 좌표가 기존 직사각형의 왼쪽 좌표보다 작은 경우, 겹치지 않는 왼쪽 부분만 잘라서 새로운 직사각형을 만듦
       ```
       new int[]{current[LEFT], current[TOP], rectangle[LEFT], current[BOTTOM]}
       ```
       _기존 직사각형의 오른쪽 좌표가 현재 직사각형의 왼쪽 좌표로 대체됩니다._
    2. 현재 직사각형의 오른쪽 좌표가 기존 직사각형의 오른쪽 좌표보다 큰 경우, 겹치지 않는 오른쪽 부분만 잘라서 새로운 직사각형을 만듦
       ```
       new int[]{rectangle[RIGHT], current[TOP], current[RIGHT], current[BOTTOM]}
       ```
       _현재 직사각형의 왼쪽 좌표가 기존 직사각형의 오른쪽 좌표로 대체됩니다._
    3. 현재 직사각형의 위쪽 좌표가 기존 직사각형의 위쪽 좌표보다 큰 경우, 겹치지 않는 위쪽 부분만 잘라서 새로운 직사각형을 만듦
       ```
       new int[]{Math.max(rectangle[LEFT], current[LEFT]), current[TOP], Math.min(rectangle[RIGHT], current[RIGHT]), rectangle[TOP]}
       ```
       _현재 직사각형의 아래쪽 좌표를 기존 직사각형의 위쪽 좌표로 대체한 뒤, 좌우측 또한 겹치지 않는 부분을 추가합니다. 왼쪽의 경우 비교해서 큰 값으로, 오른쪽의 경우 비교해서 작은 값으로 추가해야 겹치지
       않는 부분을 추가할 수 있습니다._
    4. 현재 직사각형의 아래쪽 좌표가 기존 직사각형의 아래쪽 좌표보다 작은 경우, 겹치지 않는 아래쪽 부분만 잘라서 새로운 직사각형을 만듦
       ```
       new int[]{Math.max(rectangle[LEFT], current[LEFT]), rectangle[BOTTOM], Math.min(rectangle[RIGHT], current[RIGHT]), current[BOTTOM]}
       ```
       _현재 직사각형의 위쪽 좌표를 기존 직사각형의 아래쪽 좌표로 대체한 뒤, 위에서 비교한 것 처럼 동일하게 비교하여 겹치지 않는 부분만 추가합니다._
3. 다른 직사각형과의 비교를 위해 `helper` 메서드를 재귀호출 하면서 새로 만든 직사각형과 증가한 index 값을 전달합니다.
4. 1~3의 작업이 순서대로 반복되면서 직사각형이 순차적으로 추가됩니다.

```java
for (int[] subRectangle : all)
            result = (result + (long) (subRectangle[RIGHT] - subRectangle[LEFT]) * (long) (subRectangle[BOTTOM] - subRectangle[TOP])) % MODULO;
```

추가된 직사각형을 순차적으로 참조하면서 각 넓이를 구해 `modulo` 값으로 나눠 결과에 더해줍니다.
