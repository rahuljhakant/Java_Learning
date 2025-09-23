package Coding_Questions;

import java.util.*;

public class reverse_an_array {
    public static void main(String[] args) {
        int[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] reversedArray = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            reversedArray[i] = integerArray[integerArray.length - 1 - i];
        }
        System.out.println(Arrays.toString(reversedArray));
    }
}
