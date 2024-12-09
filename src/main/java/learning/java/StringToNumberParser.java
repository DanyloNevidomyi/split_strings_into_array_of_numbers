package learning.java;

import java.util.ArrayList;
import java.util.List;

public class StringToNumberParser {
    public List<Integer> parseStringToNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Введений рядок не може бути null або пустим");
        }

        // Регулярний вираз для обробки чисел
        String[] parts = input.split("[^\\d-]+");
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            if (!part.isEmpty()) {
                if (part.matches("-?\\d+")) { // Перевірка, чи рядок є числом
                    try {
                        numbers.add(Integer.parseInt(part));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Введено неправильний формат числа: " + part);
                    }
                } else {
                    throw new IllegalArgumentException("Введено неправильний формат числа: " + part);
                }
            }
        }

        return numbers;
    }
}
