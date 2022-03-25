package Coding_Questions;

public class reverse_word_in_a_given_String {
    public static void main(String[] args) {
        String str = "Hello my name is Rahul";
        String[] strArray = str.split(" ");

        for (int i = strArray.length - 1; i >= 0; i--) {
            System.out.print(strArray[i] + " ");
        }
    }
}
