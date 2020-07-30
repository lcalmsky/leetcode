package io.lcalmsky.leetcode.student_attendance_record_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentAttendanceRecord2Test {
    @Test
    public void givenNumberOfStudent_whenFindNumberOfAllPossibleAttendanceRecords_thenCorrect() {
        assertAll(
                () -> test(2, 8)
        );
    }

    private void test(int given, int expected) {
        // when
        StudentAttendanceRecord2 studentAttendanceRecord2 = new StudentAttendanceRecord2();
        int actual = studentAttendanceRecord2.checkRecord(given);

        // then
        assertEquals(expected, actual);
    }
}