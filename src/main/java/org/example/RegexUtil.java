package org.example;
/*This is the plus symbol, and it applies to the character class [a-z].
It means that one or more lowercase letters are expected.*/
public class RegexUtil {
    public static void main(String[] args) {
        String str = "bhartendu123";
        System.out.println(onlyChars(str));
    }

    private static boolean onlyChars(String str) {
        return str.matches("[a-zA-Z]+");
    }
}
