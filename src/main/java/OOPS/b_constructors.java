package OOPS;

public class b_constructors {

  // Constructor Chaining
  public b_constructors() {
    System.out.println("Default constructor called");
  }

  public b_constructors(int a) {
    this();
    System.out.println("Constructor with int parameter: " + a);
  }

  public b_constructors(String c) {
    this(10);
    System.out.println("Constructor with String parameter: " + c);
  }

  public static void main(String[] args) {
    System.out.println("=== Constructor Chaining Demo ===");
    b_constructors obj1 = new b_constructors();
    System.out.println();
    
    b_constructors obj2 = new b_constructors(42);
    System.out.println();
    
    b_constructors obj3 = new b_constructors("Hello");
  }
}
