## Analysis


```
public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");

        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (stack.isEmpty() || !s.equals("#")) {
                stack.push(s);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
            stack.push("#");
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
```