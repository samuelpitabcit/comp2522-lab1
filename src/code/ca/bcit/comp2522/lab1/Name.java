package ca.bcit.comp2522.lab1;

/**
 * Simple name class with first and last name parameters.
 *
 * @author  Samuel Pita
 * @version 1.0
 */
public class Name {
    private final String first;
    private final String last;

    /**
     * Constructs a new {@code Name} object with the specified first and last names.
     *
     * @param first The first name.
     * @param last  The last name.
     */
    public Name(final String first, final String last) {
        this.first = first;
        this.last = last;
    }

    private static String reverseString(final String string) {
        if (string == null)
            throw new NullPointerException();

        char[] chars;
        int    left;
        int    right;

        chars = string.toCharArray();
        left  = 0;
        right = chars.length - 1;

        while (left < right) {
            char temp;

            temp         = chars[left];
            chars[left]  = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Returns the initials of the first and last names.
     * The initials are the first character of each name, concatenated together.
     *
     * @return A {@code String} containing the two initials.
     */
    public String getInitials() {
        final char firstNameInitial;
        final char lastNameInitial;

        firstNameInitial = this.first.charAt(0);
        lastNameInitial = this.last.charAt(0);

        return "" + firstNameInitial + lastNameInitial;
    }

    /**
     * Returns the full name by combining the first and last names.
     * The names are separated by a space.
     *
     * @return A {@code String} representing the full name.
     */
    public String getFullName() {
        return this.first + " " + this.last;
    }

    /**
     * Returns the reversed full name by combining the first and last names,
     * then reversing the text.
     * The names are separated by a space.
     *
     * @return A {@code String} representing the full name.
     */
    public String getReversedFullName() {
        return reverseString(getFullName());
    }
}
