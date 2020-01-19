package io.lcalmsky.leetcode.excel_sheet_column_number;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int sum = 0;

        for (int i = s.length() - 1, j = 0; i >= 0; i--) {
            int num = (s.charAt(i) - 'A') + 1;
            sum += num * Math.pow(26, j++);
        }
        return sum;
    }
}