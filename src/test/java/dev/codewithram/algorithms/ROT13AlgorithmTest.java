package dev.codewithram.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ROT13AlgorithmTest {

    @Test
    @DisplayName("Strings with lower letters only")
    void testSomething1() {
        Assertions.assertEquals("uryyb", ROT13Algorithm.rot13("hello"),
                "For input: `hello`");
    }

    @Test
    @DisplayName("Strings with upper and lower case letters")
    void testSomething2() {
        Assertions.assertEquals("UryybJbeyq", ROT13Algorithm.rot13("HelloWorld"),
                "For input: `HelloWorld`");
    }

    @Test
    @DisplayName("Strings with spaces and special characters")
    void testSomething3() {
        Assertions.assertEquals("Uryyb Jbeyq!", ROT13Algorithm.rot13("Hello World!"),
                "For input: `Hello World!`");
    }

    @Test
    @DisplayName("Strings with only special characters, digits and spaces")
    void testSomething4() {
        Assertions.assertEquals("123@#!!#@  33", ROT13Algorithm.rot13("123@#!!#@  33"),
                "For input: `123@#!!#@  33`");
    }

    @Test
    @DisplayName("Strings with only special characters, digits, spaces and letters")
    void testSomething5() {
        Assertions.assertEquals("J3 ne3 va lr@e 2023$$$!äöü", ROT13Algorithm.rot13("W3 ar3 in ye@r 2023$$$!äöü"),
                "For input: `W3 ar3 in ye@r 2023$$$!äöü`");
    }

}