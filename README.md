# Remove Duplicate Characters

This repository contains a Java project that demonstrates various methods for removing duplicate characters from a given string. The project also includes comprehensive test coverage using JUnit 5.

## Overview

The main functionality is implemented in the `Main` class under the package `com.github.luishdezortega`. It provides several static methods that accept a `String` and return a new `String` with duplicate characters removed. The methods use different approaches:
- Using aLinkedHashSet`
- A performance-optimized approach (for ASCII-compatible strings)
- A solution leveraging Java's Stream API

The accompanying tests in `MainTest` use parameterized tests to ensure that all methods behave as expected.

## How It Works

1. **Main.java**  
   Contains three methods:
   - `removeDuplicateCharacters(String input)`: Uses a `LinkedHashSet` to maintain the order and remove duplicates.
   - `removeDuplicateCharacters_perfomance(String input)`: Uses a boolean array (optimized for ASCII strings) to remove duplicates.
   - `removeDuplicateCharacters_stream_api(String input)`: Utilizes the Stream API with `distinct()` for a concise solution.

   
2. **MainTest.java**  
   Uses JUnit 5 parameterized tests to run multiple test cases on all static methods in `Main` that accept a single `String` parameter. The tests verify that duplicate characters are removed correctly. The test class uses reflection to dynamically invoke each eligible method from the `Main` class.

## Test Cases
The following test cases are provided to verify the correctness of the implementations:

| Input           | Expected Output |
|-----------------|-----------------|
| "banana"        | "ban"           |
| "hello"         | "helo"          |
| "aaaa"          | "a"             |
| "abcabc"        | "abc"           |
| ""              | ""              |
| "a"             | "a"             |
| "AaBbCc"        | "AaBbCc"        |
| "112233"        | "123"           |
| "!@!!@@"        | "!@"            |
| "AABBCCD112233" | "ABCD123"       |

## Running the Tests

This project uses Maven (or your preferred build tool) with JUnit 5. To run the tests, use your IDE's test runner or execute the following command in your project directory:
 `mvn test`
