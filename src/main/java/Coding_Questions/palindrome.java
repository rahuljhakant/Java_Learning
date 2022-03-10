package Coding_Questions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class palindrome {
    public static void main(String[] args) {
        String palindrome_word = "malayalam";
        char[] ch1 = palindrome_word.toCharArray();
        char[] ch2 = new char[ch1.length];
        System.arraycopy(ch1, 0, ch2, 0, ch1.length - 1 + 1);
        if (Arrays.equals(ch1, ch1)) System.out.println("String is a palindrome string!!");
    }
}
