package Java_Basics;

/*
 * Casting is a process of changing one type value to another type.
 * In Java, we can cast one type of value to another type. It is known as type casting.
 *
 * In Java, type casting is classified into two types,
 * 1. Widening Casting(Implicit)
 * 2. Narrowing Casting(Explicitly done)
 *
 * widening (byte>short>int>long>float>double)
 * Narrowing (double>float>long>int>short>byte)
 *
 *  */

public class d_type_Casting {
    public static void main(String[] args) {
        // Implicit type conversion
        int a = 10;
        double b = a;

        byte c = 20;
        double d = c;

        System.out.println(b);
        System.out.println(d);

        // Explicit type conversion
        double e = 30.0;
        byte f = (byte) e;
        System.out.println(f);
    }
}
