import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        
        // Create an array to store the grades
        double[] grades = new double[numGrades];
        
        // Variable to hold the sum of grades
        double sum = 0;
        
        // Loop to input each grade and calculate the sum
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            sum += grades[i];
        }
        
        // Calculate the average
        double average = sum / numGrades;
        
        // Display the average grade
        System.out.printf("The average grade is: %.2f%n", average);
        
        scanner.close();
    }
}
