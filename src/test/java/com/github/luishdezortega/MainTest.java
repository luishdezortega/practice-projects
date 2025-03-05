package com.github.luishdezortega;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("banana", "ban"),
                Arguments.of("hello", "helo"),
                Arguments.of("aaaa", "a"),
                Arguments.of("abcabc", "abc"),
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("AaBbCc", "AaBbCc"),
                Arguments.of("112233", "123"),
                Arguments.of("!@!!@@", "!@"),
                Arguments.of("AABBCCD112233", "ABCD123")
        );
    }


    @DisplayName("Test remove duplicate characters")
    @ParameterizedTest(name = "{index} => input=\"{0}\", expected=\"{1}\"")
    @MethodSource("provideTestCases")
    void removeDuplicateCharactersTest(String input, String expected) {
        var clazz = Main.class;
        for (var method : clazz.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 1 && method.getParameterTypes()[0] == String.class) {
                try {
                    var result = (String) method.invoke(null, input);
                    if (result != null) {
                        System.out.println("Execute " + method.getName());
                        assertEquals(expected, result);
                    }
                } catch (Exception e) {
                    System.err.println("Error execute" + method.getName() + ": " + e.getMessage());
                }
            }
        }
    }
}
