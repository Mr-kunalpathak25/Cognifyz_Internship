import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter the unit of temperature (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);
        
        if (unit == 'C' || unit == 'c') {
            double fahrenheit = (temperature * 9/5) + 32;
            System.out.println(temperature + "°C is equal to " + fahrenheit + "°F");
        } else if (unit == 'F' || unit == 'f') {
            double celsius = (temperature - 32) * 5/9;
            System.out.println(temperature + "°F is equal to " + celsius + "°C");
        } else {
            System.out.println("Invalid unit of temperature entered. Please enter C or F.");
        }
        
        scanner.close();
    }
}
