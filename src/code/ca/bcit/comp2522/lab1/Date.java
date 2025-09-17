package ca.bcit.comp2522.lab1;

/**
 * Simple date class with day-month-year parameters.
 *
 * @author Jacob, May, Samuel
 * @version 1.0
 */
public class Date {
    private static final int[] DAYS_IN_MONTH_LEAP_YEAR     = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_IN_MONTH_NON_LEAP_YEAR = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int[] WEEKDAY_CALC_MONTH_CODES  = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    private static final int[] WEEKDAY_CALC_START_SUMS   = {2, 0, 6};
    private static final int   WEEKDAY_CALC_JF_LY_ADD    = 6;

    private static final int JANUARY  = 1;
    private static final int FEBRUARY = 2;

    private static final int SATURDAY  = 0;
    private static final int SUNDAY    = 1;
    private static final int MONDAY    = 2;
    private static final int TUESDAY   = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY  = 5;
    private static final int FRIDAY    = 6;

    private static final int NUM_DAYS_IN_WEEK     = 7;
    private static final int NUM_YEARS_IN_CENTURY = 100;

    private static final int MIN_YEAR = 1800;
    private static final int MAX_YEAR = 2025;

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    private static final int MIN_DAY = 1;

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs the date with the given year, month, and day.
     *
     * @param year Integer from {@value MIN_YEAR} to {@value MAX_YEAR}.
     * @param month Integer from {@value MIN_MONTH} to {@value MAX_MONTH}.
     * @param day Integer from {@value MIN_DAY} to a month-and-year-specific maximum.
     */
    public Date(final int year, final int month, final int day) {
        validateYear(year);
        validateMonth(month);
        validateDay(year, month, day);

        this.year  = year;
        this.month = month;
        this.day   = day;
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

    private static void validateDay(final int year, final int month, final int day) {
        final int maxDayOfMonth;

        if (isLeapYear(year))
            maxDayOfMonth = DAYS_IN_MONTH_LEAP_YEAR[month - 1];
        else
            maxDayOfMonth = DAYS_IN_MONTH_NON_LEAP_YEAR[month - 1];

        if (day > maxDayOfMonth)
            throw new IllegalArgumentException("Day must be between " + MIN_DAY + " and " + maxDayOfMonth);
    }

    /**
     * Determines if the year is a leap year.
     *
     * @return {@code true} if the year is a leap year; {@code false} otherwise.
     */
    public static boolean isLeapYear(final int year) {
        final int firstDivisor;
        final int secondDivisor;
        final int thirdDivisor;

        firstDivisor  = 4;
        secondDivisor = 100;
        thirdDivisor  = 400;

        return ((year % firstDivisor  == 0)
             && (year % secondDivisor != 0))
             || (year % thirdDivisor  == 0);
    }

    /**
     * Returns a number specifying the Date's weekday.
     *
     * <pre>
     * Saturday  -> 0
     * Sunday    -> 1
     * Monday    -> 2
     * Tuesday   -> 3
     * Wednesday -> 4
     * Thursday  -> 5
     * Friday    -> 6
     * </pre>
     *
     * @return A number from 0 to 6.
     */
    public int getWeekday() {
        int sum;

        final int getLastTwoDigitsOfYear;
        final int firstDivisor;
        final int divFirstDivisor;
        final int modFirstDivisor;
        final int secondDivisor;
        final int divSecondDivisor;

        sum = WEEKDAY_CALC_START_SUMS[(this.year - MIN_YEAR) / NUM_YEARS_IN_CENTURY];

        if (isLeapYear(this.year))
            if (this.month == JANUARY || this.month == FEBRUARY)
                sum += WEEKDAY_CALC_JF_LY_ADD;

        getLastTwoDigitsOfYear = this.year % NUM_YEARS_IN_CENTURY;

        firstDivisor    = 12;
        divFirstDivisor = getLastTwoDigitsOfYear / firstDivisor;
        modFirstDivisor = getLastTwoDigitsOfYear % firstDivisor;

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
     * Returns a String specifying the Date's weekday.
     *
     * @return Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, or Friday.
     */
    public String getWeekdayAsString() {
        final int weekday;

        weekday = getWeekday();

        if (weekday == SATURDAY)
            return "Saturday";
        else if (weekday == SUNDAY)
            return "Sunday";
        else if (weekday == MONDAY)
            return "Monday";
        else if (weekday == TUESDAY)
            return "Tuesday";
        else if (weekday == WEDNESDAY)
            return "Wednesday";
        else if (weekday == THURSDAY)
            return "Thursday";
        else if (weekday == FRIDAY)
            return "Friday";

        throw new IllegalArgumentException("Weekday number is not between 0 to 6.");
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
