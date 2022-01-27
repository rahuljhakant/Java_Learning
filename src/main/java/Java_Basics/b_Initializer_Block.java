/*
 * A static block in a program is a set of statements which are executed by the JVM (Java Virtual Machine) before
 * the main method. At the time of class loading, if we want to perform any task we can define that task inside the
 * static block, this task will be executed at the time of class loading. In a class, any number of a static block
 * can be defined, and this static blocks will be executed from top to bottom.
 * */

/*
 * In Java, the initializer Block is used to initialize instance data members. The initializer block is executed whenever an object is created.
 * The Initializer block is copied into Java compiler and then to every constructor. The initialization block is executed before the code in
 * the constructor.
 * */
package Java_Basics;

public class b_Initializer_Block {
  {
    System.out.println("This is an Initializer Block 1");
  }

  {
    System.out.println("This is an Initializer Block 2");
  }

  static {
    System.out.println("This will get executed before main 1");
  }

  static {
    System.out.println("This will get executed before main 2");
  }

  public b_Initializer_Block() {
    System.out.println("This is the constructor.");
  }

  public static void main(String[] args) {
    b_Initializer_Block b_initializer_block = new b_Initializer_Block();
    System.out.println("This is main method.");
  }
}
