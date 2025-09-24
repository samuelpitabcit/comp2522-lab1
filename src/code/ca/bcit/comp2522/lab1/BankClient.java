package ca.bcit.comp2522.lab1;


/**
 * Represents a bank client with personal information and account details.
 * Manages client data including name, dates, and client ID.
 * 
 * @author Jacob, Samuel, Meiko
 * @version 1.0
 */
public class BankClient {
    /** The client's name */
    private final Name clientname;
    
    /** The client's birth date */
    private final Date birthDate;
    
    /** The client's death date (null if alive) */
    private final Date deathDate;
    
    /** The date the client joined the bank */
    private final Date signupDate;
    
    /** The client's unique ID */
    private final String clientID;
    
    /** Minimum client ID length */
    private static final int MIN_CLIENT_ID_LENGTH = 6;
    
    /** Maximum client ID length */
    private static final int MAX_CLIENT_ID_LENGTH = 7;

    /**
     * Validates the client ID format.
     * 
     * @param clientID the client ID to validate
     * @throws IllegalArgumentException if client ID is invalid
     */
    private static void validateClientID(final String clientID) {
        if (clientID == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }
        final int length = clientID.length();
        if (length != MIN_CLIENT_ID_LENGTH && length != MAX_CLIENT_ID_LENGTH) {
            throw new IllegalArgumentException("Client ID must be 6 or 7 characters");
        }
    }



    /**
     * Constructs a BankClient object.
     * 
     * @param clientname the client's name
     * @param birthDate the client's birth date
     * @param deathDate the client's death date (null if alive)
     * @param signupDate the date the client joined the bank
     * @param clientID the client's unique ID
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public BankClient(final Name clientname, final Date birthDate,
                      final Date deathDate, final Date signupDate,
                      final String clientID) {
        validateClientID(clientID);
        this.clientname = clientname;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /**
     * Gets the client's name.
     *
     * @return the client's name
     */
    public Name getClientName() {
        return clientname;
    }

    /**
     * Checks if the client is alive.
     *
     * @return true if the client is alive, false if deceased
     */
    public boolean isAlive() {
        return deathDate == null;
    }
    /**
     * Gets detailed information about the client.
     *
     * @return formatted string with client details
     */
    public String getDetails() {
        return clientname.getFullName() + " client #" + clientID + " (" + (isAlive() ? "alive" : "died") + ") joined the bank on " + signupDate.getDayOfTheWeek().toLowerCase() + ", " + formatMonth(signupDate.getMonth()) + " " + signupDate.getDay() + ", " + signupDate.getYear();
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