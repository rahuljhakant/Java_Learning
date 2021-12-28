package Java_Basics;

public class h_objects_in_java {
    /*
     * To create an object Java provides various ways that we are going to discuss in this topic.
     * New keyword
     * New instance
     * Clone method
     * Deserialization
     * NewInstance() method
     * */


    h_objects_in_java(int a) {
        System.out.println("This is a constructor with value: " + a);
    }

    h_objects_in_java(int a, int b) {
        System.out.println("This is a constructor with value: " + a + " and  " + b);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        // using new keyword
        h_objects_in_java h_objects_in_java = new h_objects_in_java(20);
        System.exit(1);
        h_objects_in_java h_objects_in_java1 = new h_objects_in_java(10, 20);
    }


}
