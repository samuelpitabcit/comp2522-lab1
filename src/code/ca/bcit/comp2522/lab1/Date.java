package ca.bcit.comp2522.lab1;

import java.util.HashMap;

/**
 * Simple date class with day-month-year parameters.
 * Supports years 1800 to 2025.
 *
 * @author Samuel Pita
 * @version 1.0
 */
public class Date {
    private static final int[] WEEKDAY_CALC_MONTH_CODES = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    private static final int[] WEEKDAY_CALC_STARTING_SUM = {2, 0, 6};

    private static final int NUM_DAYS_IN_WEEK = 7;
    private static final int NUM_YEARS_IN_CENTURY = 100;

    private static final int MIN_YEAR = 1800;
    private static final int MAX_YEAR = 2025;

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    private final int year;
    private final int month;
    private final int day;

    public Date(final int year, final int month, final int day) {
        validateYear(year);
        validateMonth(month);
        validateDay(day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    private static void validateYear(final int year) {
        if (year < MIN_YEAR)
            throw new IllegalArgumentException("Year must be at, or after " + MIN_YEAR);
        else if (year > MAX_YEAR)
            throw new IllegalArgumentException("Year must be at, or before " + MAX_YEAR);
    }

    private static void validateMonth(final int month) {
        if (month < MIN_MONTH || month > MAX_MONTH)
            throw new IllegalArgumentException("Month must be between " + MIN_MONTH + " to " + MAX_MONTH + ".");
    }

    private static void validateDay(final int day) {
        if (day < MIN_DAY || day > MAX_DAY)
            throw new IllegalArgumentException("Day must be between " + MIN_DAY + " to " + MAX_DAY + ".");
    }

    private static void validateDate(final int year, final int month, final int day) {

    }

    /**
     * Determines if the year is a leap year.
     *
     * @return {@code true} if the year is a leap year; {@code false} otherwise.
     */
    public boolean isLeapYear() {
        final int firstDivisor;
        final int secondDivisor;
        final int thirdDivisor;

        firstDivisor  = 4;
        secondDivisor = 100;
        thirdDivisor  = 400;

        return ((this.year % firstDivisor  == 0)
             && (this.year % secondDivisor != 0))
             || (this.year % thirdDivisor  == 0);
    }

    public int getLastTwoDigitsOfYear() {
        return this.year % NUM_YEARS_IN_CENTURY;
    }

    /**
     *
     * @return
     */
    public int getWeekday() {
        int sum;

        final int firstDivisor;
        final int divFirstDivisor;
        final int modFirstDivisor;
        final int secondDivisor;
        final int divSecondDivisor;

        sum = WEEKDAY_CALC_STARTING_SUM[(this.year - MIN_YEAR) / NUM_YEARS_IN_CENTURY];

        firstDivisor    = 12;
        divFirstDivisor = getLastTwoDigitsOfYear() / firstDivisor;
        modFirstDivisor = getLastTwoDigitsOfYear() % firstDivisor;

        secondDivisor    = 4;
        divSecondDivisor = modFirstDivisor / secondDivisor;

        sum += this.day;
        sum += divFirstDivisor;
        sum += modFirstDivisor;
        sum += divSecondDivisor;
        sum += WEEKDAY_CALC_MONTH_CODES[this.month - 1];

        return sum % NUM_DAYS_IN_WEEK;
    }

    /**
     * Returns the date as a {@code String} in YYYY-MM-DD format.
     *
     * @return {@code String} date in YYYY-MM-DD format.
     */
    public String getYyyyMmDd() {
        final StringBuilder yyyyMmDd;

        yyyyMmDd = new StringBuilder();

        yyyyMmDd.append(this.year);
        yyyyMmDd.append("-");
        yyyyMmDd.append(this.month);
        yyyyMmDd.append("-");
        yyyyMmDd.append(this.day);

        return yyyyMmDd.toString();
    }
}
