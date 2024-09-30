import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;:',.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        // Prompt user for the desired length of the password
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Check if the length is positive
        if (length <= 0) {
            System.out.println("Password length must be greater than 0.");
            return;
        }

        // Prompt user for character types to include
        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

        // Build the character set based on user preferences
        StringBuilder characterSet = new StringBuilder();
        if (includeLowercase) {
            characterSet.append(LOWERCASE);
        }
        if (includeUppercase) {
            characterSet.append(UPPERCASE);
        }
        if (includeDigits) {
            characterSet.append(DIGITS);
        }
        if (includeSpecialChars) {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        // Check if the character set is empty
        if (characterSet.length() == 0) {
            System.out.println("No character types selected. Exiting.");
            return;
        }

        // Generate the password
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        // Display the password
        System.out.println("Generated Password: " + password.toString());
    }
}
