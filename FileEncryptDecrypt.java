import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {
    
    private static final int SHIFT = 3; // Shift value for Caesar cipher

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Choose (1) Encrypt or (2) Decrypt: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Enter the file name or path: ");
        String fileName = scanner.nextLine();

        if (choice == 1) {
            encryptFile(fileName);
        } else if (choice == 2) {
            decryptFile(fileName);
        } else {
            System.out.println("Invalid choice. Please choose 1 for Encrypt or 2 for Decrypt.");
        }

        scanner.close();
    }

    public static void encryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {
             
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(encrypt(line));
                writer.newLine();
            }
            System.out.println("File encrypted successfully as 'encrypted_" + fileName + "'");
        } catch (IOException e) {
            System.out.println("Error during encryption: " + e.getMessage());
        }
    }

    public static void decryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {
             
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(decrypt(line));
                writer.newLine();
            }
            System.out.println("File decrypted successfully as 'decrypted_" + fileName + "'");
        } catch (IOException e) {
            System.out.println("Error during decryption: " + e.getMessage());
        }
    }

    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            char encryptedChar = (char) (ch + SHIFT);
            encrypted.append(encryptedChar);
        }
        return encrypted.toString();
    }

    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            char decryptedChar = (char) (ch - SHIFT);
            decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }
}
