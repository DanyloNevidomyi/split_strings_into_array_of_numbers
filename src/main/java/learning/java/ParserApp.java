package learning.java;

import java.util.List;
import java.util.Scanner;

public class ParserApp {
    public static void main(String[] args) {
        StringToNumberParser parser = new StringToNumberParser();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок з числами (розділені пробілами, комами або іншими символами): ");
        String input = scanner.nextLine();

        try {
            List<Integer> numbers = parser.parseStringToNumbers(input);
            System.out.println("Числа, отримані з рядка: " + numbers);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
