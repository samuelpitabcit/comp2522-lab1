package ca.bcit.comp2522.lab1;

/**
 * Represents a bank account with balance, client, and transaction methods.
 * Manages account operations like deposits and withdrawals.
 * 
 * @author Jacob, Samuel, Meiko, Son
 * @version 1.0
 */
public class BankAccount {
    /** The account owner */
    private final BankClient client;

    /** The account number */
    private final String accountNumber;

    /** The date the account was opened */
    private final Date accountOpened;

    /** The date the account was closed (null if still open) */
    private final Date accountClosed;

    /** The current account balance */
    private double balance;

    /** The account PIN */
    private final int pin;
    
    /** Minimum account number length */
    private static final int MIN_ACCOUNT_NUMBER_LENGTH = 6;
    
    /** Maximum account number length */
    private static final int MAX_ACCOUNT_NUMBER_LENGTH = 7;

    /**
     * Constructs a BankAccount object.
     *
     * @param client                 the account owner
     * @param accountNumber          the account number
     * @param accountOpened          the date the account was opened
     * @param accountClosed          the date the account was closed (null if still open)
     * @param initialBalance         the account initial balance
     * @param pin                    the account PIN
     */
    public BankAccount(final BankClient client, final String accountNumber,
                       final Date accountOpened, final Date accountClosed, double initialBalance, final int pin) {
        validateAccountNumber(accountNumber);
        this.client = client;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.pin = pin;
    }


    /**
     * Withdraws funds from the account.
     * 
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if amount is negative
     */
    public void withdraw(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        this.balance -= amount;
    }
    /**
     * Withdraws funds from the account with PIN verification.
     *
     * @param amount the amount to withdraw
     * @param pinToMatch the PIN to verify
     * @throws IllegalArgumentException if amount is negative or PIN doesn't match
     */
    public void withdraw(final double amount, final int pinToMatch) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }
        if (pinToMatch != this.pin) {
            throw new IllegalArgumentException("Invalid PIN");
        }
        this.balance -= amount;
    }
    /**
     * Deposits funds into the account.
     * 
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        this.balance += amount;
    }
    /**
     * Validates the account number format.
     *
     * @param accountNumber the account number to validate
     * @throws IllegalArgumentException if account number is invalid
     */
    private void validateAccountNumber(final String accountNumber) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("Account number cannot be null");
        }
        final int length = accountNumber.length();
        if (length != MIN_ACCOUNT_NUMBER_LENGTH && length != MAX_ACCOUNT_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Account number must be 6 or 7 characters");
        }
    }

    /**
     * Gets detailed information about the account.
     *
     * @return formatted string with account details
     */
    public String getDetails() {
        return client.getClientName().getFullName() + " had $" + this.balance + " USD in account #"
                + this.accountNumber + " which he opened on " + accountOpened.getWeekdayAsString() + " " + formatMonth(accountOpened.getMonth()) + " " + accountOpened.getDay() + ", " + accountOpened.getYear()
                + (accountClosed == null ? "" : " and closed " + accountClosed.getWeekdayAsString() + " " + formatMonth(accountClosed.getMonth()) + " " + accountClosed.getDay() + ", " + accountClosed.getYear());
    }

    /**
     * Formats month number to month name.
     *
     * @param month the month number (1-12)
     * @return the month name
     */
    private String formatMonth(final int month) {
        final String[] monthNames = {"January", "February", "March", "April", "May", "June",
                                    "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }


}