/*
 * When we want to store any information, we store it in an address of the computer.
 * Instead of remembering the complex address where we have stored our information, we name that address.
 * The naming of an address is known as variable. Variable is the name of memory location.
 * */
package Java_Basics;

public class c_variables {

    /*
    > static variable are also known as class variable.
    > static means to remain constant.
    > In Java, it means that it will be constant for all the instances created for that class.
    > static variable need not be called from object.
    > It is called by classname.static_variable_name
    */
    public static int a = 10; // static variables


    String name = ""; // instance variable

    public String abc() {
        /*
         * Local variables are declared in method, constructor or block.
         * Local variables are initialized when method, constructor or block
         * start and will be destroyed once its end.
         * Local variable reside in stack.
         * Access modifiers are not used for local variable.
         * */
        int c = 20; // local variables
        return "";
    }

    public static void main(String[] args) {

    }
}
