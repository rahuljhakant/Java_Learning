package Java_Basics;

import com.sun.tools.javac.Main;

import java.time.LocalDateTime;

public class f_operators {

    /*
     * Function with parameters having dynamic data type and also object array with dynamic data type as values.
     *
     * */

    public static void main(String args[]) {
        f_operators f_operators = new f_operators();
        Object[] mixedArray = new Object[5];
        mixedArray[0] = 10;
        mixedArray[1] = "Jack";
        mixedArray[2] = true;
        mixedArray[3] = LocalDateTime.now();
        mixedArray[4] = 20.0;

        for (Object c : mixedArray) {
            f_operators.fun(c);
        }

        // ternary operator or conditional operator
        int x = 100;
        int p = 90;
        int c;
        c = x >= p ? 40 : 30;
        System.out.println(c + " : is the ternary operator result.");
    }

    public void fun(Object a) {
        if (a instanceof Integer) {
            System.out.println("a is an integer");
        } else if (a instanceof String) {
            System.out.println("b is a String");
        } else if (a instanceof Double) {
            System.out.println("a is of type double");
        } else if (a instanceof Boolean) {
            System.out.println("a is boolean");
        } else if (a instanceof LocalDateTime) {
            System.out.println("a is local date time data type");
        }
    }
}
