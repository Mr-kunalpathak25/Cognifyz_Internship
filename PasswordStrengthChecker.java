import java.util.Scanner;

public class PasswordStrengthChecker {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();
        
        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
        
        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        int lengthCriteria = password.length() >= 8 ? 1 : 0;
        int upperCaseCriteria = password.chars().anyMatch(Character::isUpperCase) ? 1 : 0;
        int lowerCaseCriteria = password.chars().anyMatch(Character::isLowerCase) ? 1 : 0;
        int numberCriteria = password.chars().anyMatch(Character::isDigit) ? 1 : 0;
        int specialCharCriteria = password.chars().anyMatch(ch -> "!@#$%^&*()-_=+<>?[]{}|;:,'\".".indexOf(ch) >= 0) ? 1 : 0;

        int criteriaMet = lengthCriteria + upperCaseCriteria + lowerCaseCriteria + numberCriteria + specialCharCriteria;

        switch (criteriaMet) {
            case 0:
            case 1:
                return "Very Weak";
            case 2:
                return "Weak";
            case 3:
                return "Moderate";
            case 4:
                return "Strong";
            case 5:
                return "Very Strong";
            default:
                return "Invalid Password"; // This should never happen
        }
    }
}
