package io.lcalmsky.leetcode.basic_calculator_ii;

import java.util.Stack;

public class Solution {

  public int calculate(String s) {
    Stack<Integer> numbers = new Stack<>();
    Stack<Character> operators = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        continue;
      }
      if (Character.isDigit(c)) {
        stringBuilder.append(c);
        continue;
      }
      numbers.push(Integer.parseInt(stringBuilder.toString()));
      stringBuilder = new StringBuilder();
      evaluateOperatorWithHigherPriority(numbers, operators);
      operators.push(c);
    }
    if (stringBuilder.length() > 0) {
      numbers.push(Integer.parseInt(stringBuilder.toString()));
    }
    evaluateOperatorWithHigherPriority(numbers, operators);
    int result = evaluateOperatorWithLowerPriority(numbers, operators);
    if (!numbers.isEmpty()) {
      result += numbers.pop();
    }
    return result;
  }

  private void evaluateOperatorWithHigherPriority(Stack<Integer> numbers,
      Stack<Character> operators) {
    if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
      char operator = operators.pop();
      int y = numbers.pop();
      int x = numbers.pop();
      numbers.push(operator == '*' ? x * y : x / y);
    }
  }

  private int evaluateOperatorWithLowerPriority(Stack<Integer> numbers,
      Stack<Character> operators) {
    int result = 0;
    while (!operators.isEmpty()) {
      char operator = operators.pop();
      int number = numbers.pop();
      result = operator == '+' ? result + number : result - number;
    }
    return result;
  }
}

class AnotherSolution {

  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int result = 0, temp = 0, number = 0;
    char operator = '+';
    for (char current : s.toCharArray()) {
      if (current >= '0' && current <= '9') {
        temp = temp * 10 + current - '0';
      } else if (current != ' ') {
        number = cal(number, temp, operator);
        if (current == '+' || current == '-') {
          result += number;
          number = 0;
        }
        temp = 0;
        operator = current;
      }
    }
    return result + cal(number, temp, operator);
  }

  private int cal(int number, int temp, char operator) {
    if (operator == '+') {
      return number + temp;
    }
    if (operator == '-') {
      return number - temp;
    }
    if (operator == '*') {
      return number * temp;
    }
    return number / temp;
  }
}