package Coding_Questions;

import java.util.Arrays;

public class number_palindrome {
    public static void main(String[] args) {
        int a = 1234554321;
        String str = String.valueOf(a);
        char[] chars = str.toCharArray();
        char[] revChar = new char[chars.length];
        System.arraycopy(chars, 0, revChar, 0, chars.length - 1 + 1);
        Arrays.equals(chars, revChar);
    }
}
