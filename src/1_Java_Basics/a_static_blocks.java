/*
A static block in a program is a set of statements which are executed by the JVM (Java Virtual Machine) before 
the main method. At the time of class loading, if we want to perform any task we can define that task inside the 
static block, this task will be executed at the time of class loading. In a class, any number of a static block 
can be defined, and this static blocks will be executed from top to bottom.
*/

class a_static_blocks {
  static {
    System.out.println("This will get executed before main 1");
  }

  static {
    System.out.println("This will get executed before main 2");
  }

  public static void main(String args[]) {
    System.out.println("This will get executed after static block");
  }

  static {
    System.out.println("This will get executed before main 3");
  }
  
}
