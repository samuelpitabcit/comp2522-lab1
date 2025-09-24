package ca.bcit.comp2522.lab1;

/**
 * Main class for testing the banking system simulation.
 * Creates test cases for Albert Einstein, Nelson Mandela, Frida Kahlo, and Jackie Chan.
 * 
 * @author Jacob, Samuel, Meiko
 * @version 1.0
 */
public class Main {

    /**
     * Main method to test the banking system with four different clients.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // Albert Einstein test case
        System.out.println("=== ALBERT EINSTEIN ===");
        Name albertName = new Name("Albert", "Einstein");
        System.out.println("Initials: " + albertName.getInitials());
        System.out.println("Full Name: " + albertName.getFullName());
        System.out.println("Reversed Name: " + albertName.getReversedFullName());
        
        BankClient albertClient = new BankClient(albertName, new Date(1879, 3, 14),
                new Date(1955, 4, 18), new Date(1900, 1, 1), "abc123");
        System.out.println("Client Details: " + albertClient.getDetails());
        
        BankAccount albertAccount = new BankAccount(albertClient, "abc123", new Date(1900, 1, 1), new Date(1950, 10, 14), 3141);
        albertAccount.deposit(1000);
        System.out.println("After deposit: " + albertAccount.getDetails());
        albertAccount.withdraw(100);
        System.out.println("After withdrawal: " + albertAccount.getDetails());
        System.out.println();

        // Nelson Mandela test case
        System.out.println("=== NELSON MANDELA ===");
        Name nelsonName = new Name("Nelson", "Mandela");
        System.out.println("Initials: " + nelsonName.getInitials());
        System.out.println("Full Name: " + nelsonName.getFullName());
        System.out.println("Reversed Name: " + nelsonName.getReversedFullName());
        
        BankClient nelsonClient = new BankClient(nelsonName, new Date(1918, 7, 18),
                new Date(2013, 12, 5), new Date(1994, 5, 10), "654321");
        System.out.println("Client Details: " + nelsonClient.getDetails());
        
        BankAccount nelsonAccount = new BankAccount(nelsonClient, "654321", new Date(1994, 5, 10), null, 4664);
        nelsonAccount.deposit(2000);
        System.out.println("After deposit: " + nelsonAccount.getDetails());
        nelsonAccount.withdraw(200);
        System.out.println("After withdrawal: " + nelsonAccount.getDetails());
        System.out.println();

        // Frida Kahlo test case
        System.out.println("=== FRIDA KAHLO ===");
        Name fridaName = new Name("Frida", "Kahlo");
        System.out.println("Initials: " + fridaName.getInitials());
        System.out.println("Full Name: " + fridaName.getFullName());
        System.out.println("Reversed Name: " + fridaName.getReversedFullName());
        
        BankClient fridaClient = new BankClient(fridaName, new Date(1907, 7, 6),
                new Date(1954, 7, 13), new Date(1940, 1, 1), "frd123");
        System.out.println("Client Details: " + fridaClient.getDetails());
        
        BankAccount fridaAccount = new BankAccount(fridaClient, "frd123", new Date(1940, 1, 1), new Date(1954, 7, 13), 1907);
        fridaAccount.deposit(500);
        System.out.println("After deposit: " + fridaAccount.getDetails());
        fridaAccount.withdraw(50);
        System.out.println("After withdrawal: " + fridaAccount.getDetails());
        System.out.println();

        // Jackie Chan test case
        System.out.println("=== JACKIE CHAN ===");
        Name jackieName = new Name("Jackie", "Chan");
        System.out.println("Initials: " + jackieName.getInitials());
        System.out.println("Full Name: " + jackieName.getFullName());
        System.out.println("Reversed Name: " + jackieName.getReversedFullName());
        
        BankClient jackieClient = new BankClient(jackieName, new Date(1954, 4, 7),
                null, new Date(1980, 10, 1), "chan789");
        System.out.println("Client Details: " + jackieClient.getDetails());
        
        BankAccount jackieAccount = new BankAccount(jackieClient, "chan789", new Date(1980, 10, 1), null, 1954);
        jackieAccount.deposit(3000);
        System.out.println("After deposit: " + jackieAccount.getDetails());
        jackieAccount.withdraw(500);
        System.out.println("After withdrawal: " + jackieAccount.getDetails());
    }
}
