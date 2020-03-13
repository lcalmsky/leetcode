### Solution

>단어들을 길이의 내림차순으로 정렬한 뒤 비트 시프트를 이용해 단어의 차를 구하는 것이 포인트!

- 정렬
```
Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
```

- 비트 시프트
```
int[] marks = new int[words.length];
for (int i = 0; i < words.length; ++i) {
    char[] array = words[i].toCharArray();
    for (char c : array) marks[i] |= 1 << (c - 'a');
}
```

위의 반복문을 실행하면 아래와 같은 순서로 데이터가 가공된다.
>원리는 비트 플래그를 활용한 것으로 a일 때 첫 번 째 비트가 1, b일 때 두 번 째 비트가 1, 이런식으로 플래그가 on(1) 상태가 되므로 현재 단어가 포함하고 있는 알파벳에 해당하는 비트만 체크하여 다른 단어와 비교하기 위함이다.
>Integer는 4Byte이고 이는 32비트 이므로 26개의 알파벳 유무를 표현하기 충분하다.
>ex1) a     = 0000 0000 0000 0000 0000 0000 0000 0001
>ex2) abcde = 0000 0000 0000 0000 0000 0000 0001 1111
>ex3) fghij = 0000 0000 0000 0000 0000 0011 1110 0000

```
let words = {"abcw","baz","foo","bar","xtfn","abcdef"}

for i in range (0, words.lenth)
    when i = 0
        array = {'a', 'b', 'c', 'w'}
        foreach c in {'a', 'b', 'c', 'w'}
            when c = 'a'
                marks[0] = 0 |= 1 << ('a' - 'a')
                         = 0 |= 1 << 0
                         = 0 |= 1
                         = 1
            when c = 'b' 
                marks[0] = 1 |= 1 << ('b' - 'a')
                         = 1 |= 1 << 1
                         0000 0000 0000 0001 << 1
                         0000 0000 0000 0010 => 2
                         = 1 |= 2
                         0001 | 0010 = 0011 => 3
                         = 3
            when c = 'c'
                marks[0] = 3 |= 1 << ('c' - 'a')
                         = 3 |= 1 << 2
                         0000 0000 0000 0001 << 2
                         0000 0000 0000 0110 => 6
                         = 3 |= 6
                         0011 | 0110 = 0111 => 7
                         = 7
            when c = 'w'
                marks[0] = 7 |= 1 << ('w' - 'a')
                         = 7 |= 1 << 22
                         = 7 |= 4194311
                         (숫자가 너무 길어서 생략)
                         = 4194311
```

위와 같은 식으로 marks 배열을 채워나가면

```
marks[0] = 4194311
marks[1] = 33554435
marks[2] = 16416
marks[3] = 131075
marks[4] = 8921120
marks[5] = 63 
```

위와 같은 결과를 얻게 된다.

marks 배열에 비트 시프트와 '|' 연산자를 통해 구한 값들은 가지고 두 값의 공통 부분이 없을 때('&' 의 결과가 0이 아닐 때) 각 단어의 길이를 곱해 max 값을 구한다.

```
for i in range (0, marks.length)
    when i = 0
        if words[0].length * words[0].length <= max // 길이로 내림차순 정렬하였으므로 max 값을 한 번 구한 이후로 해당하지 않는 나머지 부분을 생략
            break;
        for j in range (i + 1, marks.length)
            when j = 1
                if marks[1] & marks[0] == 0 // 두 단어가 중복되는 문자를 갖고있지 않으면
                // 33554435 & 4194311 = 3 => continue
            when j = 2
                // 16416 & 4194311 = 0
                max = Math.max(max, words[0].length * words[2].length)
                max = Math.max(0, 4 * 3 = 12) = 12 
                break
    when i = 1
        ...
```

위와 같은 방식으로 중복을 포함하지 않는 단어들의 길이를 곱해 max 값을 갱신해나가면 원하는 값을 얻을 수 있다.

```
words[0] * words[0] = 36, max = 0, do next
marks[1] & marks[0] = 7
marks[2] & marks[0] = 32
marks[3] & marks[0] = 3
marks[4] & marks[0] = 32
marks[5] & marks[0] = 3
words[1] * words[1] = 16, max = 0, do next
marks[2] & marks[1] = 0
max = Math.max(16, words[1].length * words[2].length)
    = Math.max(16, 16)
    = 16
words[2] * words[2] = 16, max = 16, break!
```

>단어 길이로 정렬했으므로 더 이상 확인할 필요가 없다.
