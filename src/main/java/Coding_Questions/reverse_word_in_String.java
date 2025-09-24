package Coding_Questions;
public class reverse_word_in_String {
    public static void main(String[] args) {
        String sentence = "My name is Rahul Kant Jha";
        String[] words = sentence.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }
}
