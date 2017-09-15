package com.hello;

public class DayOfProgrammer {
    public static int[] DAYS_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int DAY_OF_PROGRAMMER = 256;

    public static String solve(int year) {
        // Start from first month
        int month = 0;
        int day = DAY_OF_PROGRAMMER;

        // Find the basic month firstly
        for (; month < 12; month++) {
            int days = DAYS_OF_MONTH[month];
            if (day > days) {
                day -= days;
            } else {
                break;
            }
        }

        // Adjust: the transition year 1918
        if (year == 1918) {
            day += 13;

            // Forward one month
            if (day > DAYS_OF_MONTH[month]) {
                day -= DAYS_OF_MONTH[month];
                month++;
            }
        }

        // If it's leap year
        if ((year > 1918 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) || (year < 1918 && year % 4 == 0)) {
            day -= 1;

            // Back one month
            if (day <= 0) {
                month--;
                day += DAYS_OF_MONTH[month];
            }
        }

        return String.format("%02d.%02d.%04d", day, month + 1, year);
    }
}
