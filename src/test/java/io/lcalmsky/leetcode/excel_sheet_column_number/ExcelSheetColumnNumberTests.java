package io.lcalmsky.leetcode.excel_sheet_column_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelSheetColumnNumberTests {
    @Test
    public void givenString_whenFindColumnNumber_thenCorrect() {
        assertAll(
                () -> test("A", 1),
                () -> test("AB", 28),
                () -> test("ZY", 701),
                () -> test("AAA", 703)
        );
    }

    private void test(String given, int expected) {
        // when
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        int actual = excelSheetColumnNumber.titleToNumber(given);

        // then
        assertEquals(expected, actual);
    }
}