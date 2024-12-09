package learning.java;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringToNumberParserTest {
    private StringToNumberParser parser;

    @BeforeEach
    void setUp() {
        parser = new StringToNumberParser();
    }

    @Test
    @DisplayName("Parse valid string with spaces")
    void testParseValidStringWithSpaces() {
        String input = "10 20 30";
        List<Integer> expected = Arrays.asList(10, 20, 30);
        assertEquals(expected, parser.parseStringToNumbers(input));
    }

    @Test
    @DisplayName("Parse valid string with mixed delimiters")
    void testParseValidStringWithMixedDelimiters() {
        String input = "10,20;30|40";
        List<Integer> expected = Arrays.asList(10, 20, 30, 40);
        assertEquals(expected, parser.parseStringToNumbers(input));
    }

    @Test
    @DisplayName("Handle negative numbers")
    void testParseStringWithNegativeNumbers() {
        String input = "-10 -20 30";
        List<Integer> expected = Arrays.asList(-10, -20, 30);
        assertEquals(expected, parser.parseStringToNumbers(input));
    }

    @Test
    @DisplayName("Handle empty string")
    void testParseEmptyString() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> parser.parseStringToNumbers(input));
    }

    @Test
    @DisplayName("Handle null input")
    void testParseNullInput() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseStringToNumbers(null));
    }

    @Test
    @DisplayName("Parse string with only delimiters")
    void testParseStringWithOnlyDelimiters() {
        String input = ",,;;||";
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, parser.parseStringToNumbers(input));
    }

}