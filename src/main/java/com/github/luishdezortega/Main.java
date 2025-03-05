package com.github.luishdezortega;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Main {

    /*
    Given a simple String AABBCCD112233. All you need is to return a new String, that will not contain any duplicates.
    The code should be clean, readable and optimized. Also, we expect to see test coverage with different test cases.
     */
    public static void main(String[] args) {
        var input = "AABBCCD112233";
        removeDuplicateCharacters(input);
        removeDuplicateCharacters_perfomance(input);
        removeDuplicateCharacters_stream_api(input);

    }

    public static String removeDuplicateCharacters(String input) {
        /*
        This was the first functional solution. I relied on the definition of SET to perform the removal and,
        by iterating through the result, I constructed a new String
         */
        var uniqueCharacter = new LinkedHashSet<Character>(input.length());
        for (var c : input.toCharArray()) {
            uniqueCharacter.add(c);
        }
        var result = new StringBuilder(uniqueCharacter.size());

        for (char c : uniqueCharacter) {
            result.append(c);
        }
        return result.toString();
    }

    public static String removeDuplicateCharacters_perfomance(String input) {
        /*
      In the solution, I have two loops; in this case, I'll focus on reducing them for better performance.
      With that in mind, a great alternative is to handle the solution by defining that the input string is ASCII-compatible
       */
        var seen = new boolean[128];
        var result = new StringBuilder(input.length());

        for (var c : input.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String removeDuplicateCharacters_stream_api(String input) {
        /*
     As can be seen, to do this we work with arrays or lists, which leads us to think about collections,
     thus moving into Java's Stream API
       */
        return input.chars()
                .distinct()
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }


}