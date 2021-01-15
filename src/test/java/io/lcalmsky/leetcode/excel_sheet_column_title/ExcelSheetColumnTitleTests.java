package io.lcalmsky.leetcode.excel_sheet_column_title;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelSheetColumnTitleTests {
    @Test
    public void givenNumber_whenConvertToExcelColumnTitle_thenCorrect() {
        assertAll(
                () -> test(1, "A"),
                () -> test(28, "AB"),
                () -> test(26, "Z"),
                () -> test(701, "ZY")
        );
    }

    private void test(int given, String expected) {
        // when
        Solution excelSheetColumnTitle = new Solution();
        String actual = excelSheetColumnTitle.convertToTitle(given);

        // then
        assertEquals(expected, actual);
    }
}
