package Coding_Questions;

public class palindrome_string {
    public static void main(String[] args) {
        String palindrome_word = "malayalam";
        boolean isPalindrome = true;
        
        for (int i = 0; i < palindrome_word.length() / 2; i++) {
            if (palindrome_word.charAt(i) != palindrome_word.charAt(palindrome_word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        System.out.println("Word: " + palindrome_word);
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
