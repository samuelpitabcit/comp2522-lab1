package ca.bcit.comp2522.lab1;

/**
 * Main class for testing the banking system simulation.
 * Creates test cases for Albert Einstein, Nelson Mandela, Frida Kahlo, and Jackie Chan.
 * 
 * @author Jacob, Samuel, Meiko, Son
 * @version 1.0
 */
public class Main {
    // Albert Einstein test case
    private static final Name EINSTEIN_NAME = new Name("Albert", "Einstein");
    private static final Date EINSTEIN_BIRTH_DATE = new Date(1879, 3, 14);
    private static final Date EINSTEIN_DEATH_DATE = new Date(1955, 4, 18);
    private static final Date EINSTEIN_SIGNUP_DATE = new Date(1900, 1, 1);
    private static final Date EINSTEIN_CLOSE_DATE = new Date(1950, 10, 14);
    private static final String EINSTEIN_CLIENT_ID = "123456";
    private static final String EINSTEIN_ACCOUNT_NUMBER = "abc123";
    private static final int EINSTEIN_PIN = 3141;
    private static final double EINSTEIN_INITIAL_BALANCE = 1000;
    private static final double EINSTEIN_WITHDRAW_AMOUNT = 100;

    // Nelson Mandela test case
    private static final Name MANDELA_NAME = new Name("Nelson", "Mandela");
    private static final Date MANDELA_BIRTH_DATE = new Date(1918, 7, 18);
    private static final Date MANDELA_DEATH_DATE = new Date(2013, 12, 5);
    private static final Date MANDELA_SIGNUP_DATE = new Date(1994, 5, 10);
    private static final String MANDELA_CLIENT_ID = "654321";
    private static final String MANDELA_ACCOUNT_NUMBER = "654321";
    private static final int MANDELA_PIN = 4664;
    private static final double MANDELA_INITIAL_BALANCE = 2000.0;
    private static final double MANDELA_WITHDRAW_AMOUNT = 200.0;

    // Frida Kahlo test case
    private static final Name KAHLO_NAME = new Name("Frida", "Kahlo");
    private static final Date KAHLO_BIRTH_DATE = new Date(1907, 7, 6);
    private static final Date KAHLO_DEATH_DATE = new Date(1954, 7, 13);
    private static final Date KAHLO_SIGNUP_DATE = new Date(1940, 1, 1);
    private static final Date KAHLO_CLOSE_DATE = new Date(1954, 7, 13);
    private static final String KAHLO_CLIENT_ID = "frd123";
    private static final String KAHLO_ACCOUNT_NUMBER = "frd123";
    private static final int KAHLO_PIN = 1907;
    private static final double KAHLO_INITIAL_BALANCE = 500.0;
    private static final double KAHLO_WITHDRAW_AMOUNT = 50.0;

    // Jackie Chan test case
    private static final Name CHAN_NAME = new Name("Jackie", "Chan");
    private static final Date CHAN_BIRTH_DATE = new Date(1954, 4, 7);
    private static final Date CHAN_SIGNUP_DATE = new Date(1980, 10, 1);
    private static final String CHAN_CLIENT_ID = "chan789";
    private static final String CHAN_ACCOUNT_NUMBER = "chan789";
    private static final int CHAN_PIN = 1954;
    private static final double CHAN_INITIAL_BALANCE = 3000.0;
    private static final double CHAN_WITHDRAW_AMOUNT = 500.0;

    /**
     * Main method to test the banking system with four different clients.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // Albert Einstein test case
        final BankClient einsteinClient = new BankClient(
                EINSTEIN_NAME, EINSTEIN_BIRTH_DATE, EINSTEIN_DEATH_DATE,
                EINSTEIN_SIGNUP_DATE, EINSTEIN_CLIENT_ID);

        final BankAccount einsteinAccount = new BankAccount(
                einsteinClient, EINSTEIN_ACCOUNT_NUMBER, EINSTEIN_SIGNUP_DATE,
                EINSTEIN_CLOSE_DATE, EINSTEIN_INITIAL_BALANCE, EINSTEIN_PIN);

        System.out.println(EINSTEIN_NAME.getInitials());
        System.out.println(EINSTEIN_NAME.getFullName());
        System.out.println(EINSTEIN_NAME.getReversedFullName());
        System.out.println(einsteinClient.getDetails());
        System.out.println(einsteinAccount.getDetails());

        einsteinAccount.withdraw(EINSTEIN_WITHDRAW_AMOUNT);
        System.out.println(einsteinAccount.getDetails());

        // Nelson Mandela test case
        BankClient mandelaClient = new BankClient(
                MANDELA_NAME, MANDELA_BIRTH_DATE, MANDELA_DEATH_DATE,
                MANDELA_SIGNUP_DATE, MANDELA_CLIENT_ID);

        BankAccount mandelaAccount = new BankAccount(
                mandelaClient, MANDELA_ACCOUNT_NUMBER, MANDELA_SIGNUP_DATE,
                null, MANDELA_INITIAL_BALANCE, MANDELA_PIN);

        System.out.println(MANDELA_NAME.getInitials());
        System.out.println(MANDELA_NAME.getFullName());
        System.out.println(MANDELA_NAME.getReversedFullName());
        System.out.println(mandelaClient.getDetails());
        System.out.println(mandelaAccount.getDetails());

        mandelaAccount.withdraw(MANDELA_WITHDRAW_AMOUNT);
        System.out.println(mandelaAccount.getDetails());

        // Frida Kahlo test case
        BankClient kahloClient = new BankClient(
                KAHLO_NAME, KAHLO_BIRTH_DATE, KAHLO_DEATH_DATE,
                KAHLO_SIGNUP_DATE, KAHLO_CLIENT_ID);

        BankAccount kahloAccount = new BankAccount(
                kahloClient, KAHLO_ACCOUNT_NUMBER, KAHLO_SIGNUP_DATE,
                KAHLO_CLOSE_DATE, KAHLO_INITIAL_BALANCE, KAHLO_PIN);

        System.out.println(KAHLO_NAME.getInitials());
        System.out.println(KAHLO_NAME.getFullName());
        System.out.println(KAHLO_NAME.getReversedFullName());
        System.out.println(kahloClient.getDetails());
        System.out.println(kahloAccount.getDetails());

        kahloAccount.withdraw(KAHLO_WITHDRAW_AMOUNT);
        System.out.println(kahloAccount.getDetails());

        // Jackie Chan test case
        BankClient chanClient = new BankClient(
                CHAN_NAME, CHAN_BIRTH_DATE, null,
                CHAN_SIGNUP_DATE, CHAN_CLIENT_ID);

        BankAccount chanAccount = new BankAccount(
                chanClient, CHAN_ACCOUNT_NUMBER, CHAN_SIGNUP_DATE,
                null, CHAN_INITIAL_BALANCE, CHAN_PIN);

        System.out.println(CHAN_NAME.getInitials());
        System.out.println(CHAN_NAME.getFullName());
        System.out.println(CHAN_NAME.getReversedFullName());
        System.out.println(chanClient.getDetails());
        System.out.println(chanAccount.getDetails());

        chanAccount.withdraw(CHAN_WITHDRAW_AMOUNT);
        System.out.println(chanAccount.getDetails());
    }
}
