package ca.bcit.comp2522.lab1;

/**
 * Simple date class with day-month-year parameters.
 * Supports years 1800 to 2025.
 *
 * @author Jacob, Samuel, May
 * @version 1.0
 */
public class Date {

    private final int year;
    private final int month;
    private final int day;
    
    /** Current year for validation */
    public static final int CURRENT_YEAR = 2025;
    
    /** Minimum valid year */
    private static final int MIN_YEAR = 1800;
    
    /** Maximum valid year */
    private static final int MAX_YEAR = CURRENT_YEAR;
    
    /** Number of months in a year */
    private static final int MONTHS_IN_YEAR = 12;
    
    /** Days in a week */
    private static final int DAYS_IN_WEEK = 7;
    
    /** Month codes for day-of-week calculation */
    private static final int[] MONTH_CODES = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    
    /** Divider for year calculation */
    private static final int YEAR_DIVIDER = 12;
    
    /** Divider for remainder calculation */
    private static final int REMAINDER_DIVIDER = 4;
    
    /** Extra days for leap years */
    private static final int LEAP_YEAR_EXTRA = 6;
    
    /** Extra days for 2000s */
    private static final int YEAR_2000_EXTRA = 6;
    
    /** Extra days for 1800s */
    private static final int YEAR_1800_EXTRA = 2;

    /**
     * Determines if a year is a leap year.
     * 
     * @param year the year to check
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(final int year) {
       return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    /**
     * Creates a Date object using a static factory method.
     * Returns null if any argument is null.
     * 
     * @param args array containing year, month, day
     * @return new Date object or null if invalid
     * @throws IllegalArgumentException if date values are invalid
     */
    public static Date createDate(final Integer... args) {
        if (args == null) {
            return null;
        }

        for (Integer i : args) {
        if (i == null) return null;
        }

        final int yearValue = args[0].intValue();
        final int monthValue = args[1].intValue();
        final int dayValue = args[2].intValue();

        validateDate(yearValue, monthValue, dayValue);

        return new Date(yearValue, monthValue, dayValue);
    }

    /**
     * Validates date components.
     * 
     * @param year the year to validate
     * @param month the month to validate
     * @param day the day to validate
     * @throws IllegalArgumentException if any date component is invalid
     */
    private static void validateDate(final int year, final int month, final int day) {
        final boolean yearCheck = year <= MAX_YEAR && year >= MIN_YEAR;
        if (!yearCheck) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }

        final int maxDay = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> throw new IllegalArgumentException("Invalid month: " + month);
        };

        final boolean dayCheck = day <= maxDay && day >= 1;
        if (!dayCheck) {
            throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    /**
     * Constructs a Date object.
     * 
     * @param year the year (1800-2025)
     * @param month the month (1-12)
     * @param day the day (1-31, varies by month)
     */
    public Date(final int year, final int month, final int day) {
        validateDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }


    /**
     * Gets the day of the month.
     * 
     * @return the day (1-31)
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Gets the month.
     * 
     * @return the month (1-12)
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Gets the year.
     * 
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the date in YYYY-MM-DD format.
     * 
     * @return formatted date string
     */
    public String getYYYYMMDD() {
        return year + "-" + month + "-" + day;
    }

    /**
     * Calculates the day of the week for this date.
     * 
     * @return the day of the week (Saturday through Friday)
     */
    public String getDayOfTheWeek() {
        final int step1 = this.year % 100 / YEAR_DIVIDER;
        final int step2 = this.year % 100 % YEAR_DIVIDER;
        final int step3 = step2 / REMAINDER_DIVIDER;
        final int step4 = step1 + step2 + step3 + switch (this.month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> throw new IllegalStateException("An error has occurred on month");
        };
        final int step5 = step4 + MONTH_CODES[this.month - 1];

        int extra = 0;
        if (isLeapYear(year) && (month == 2 || month == 1)) {
            extra += LEAP_YEAR_EXTRA;
        }
        if (year / 1000 == 2) {
            extra += YEAR_2000_EXTRA;
        }
        if (year / 100 == 18) {
            extra += YEAR_1800_EXTRA;
        }
        final int step6 = (step5 + extra) % DAYS_IN_WEEK;
        return switch (step6) {
            case 0 -> "Saturday";
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            default -> throw new IllegalStateException("An error has occurred on MoD function");
        };
    }

}
