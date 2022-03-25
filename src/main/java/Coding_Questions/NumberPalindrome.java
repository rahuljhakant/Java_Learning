package Coding_Questions;
import java.util.logging.Level;
import java.util.Arrays;
import utility.*;

public class NumberPalindrome implements Util {
    public static void main(String[] args) {
        int a = 1234554321;
        String str = String.valueOf(a);
        char[] chars = str.toCharArray();
        char[] revChar = new char[chars.length];
        System.arraycopy(chars, 0, revChar, 0, chars.length - 1 + 1);
        logger.log(Level.INFO, String.valueOf(Arrays.equals(chars, revChar)), "Checking if integer number is palindrome or not.");
    }
}
