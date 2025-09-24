package STRING_HANDLING;

public class String_Buffer {

  public static void main(String[] args) {
    System.out.println("=== String vs StringBuffer Demo ===");
    System.out.println();
    
    // String immutability demonstration
    System.out.println("1. String Immutability:");
    System.out.println("======================");
    String s = "single".concat(" Plus");
    System.out.println("After first concat: " + s);
    
    // This doesn't modify the original string
    s.concat("  +  another string");
    System.out.println("After second concat (no assignment): " + s);
    
    // To see the effect, we need to assign the result
    s = s.concat("  +  another string");
    System.out.println("After second concat (with assignment): " + s);
    System.out.println();
    
    // StringBuffer mutability demonstration
    System.out.println("2. StringBuffer Mutability:");
    System.out.println("===========================");
    StringBuffer stringBuffer = new StringBuffer("APACHE");
    System.out.println("Original StringBuffer: " + stringBuffer);
    
    // StringBuffer is mutable - append modifies the original object
    StringBuffer ss = stringBuffer.append(" + integer");
    System.out.println("After append: " + stringBuffer);
    System.out.println("Returned reference: " + ss);
    System.out.println("Same object? " + (stringBuffer == ss));
    System.out.println("Instance of StringBuffer? " + (ss instanceof StringBuffer));
    System.out.println();
    
    // Additional StringBuffer methods
    System.out.println("3. StringBuffer Methods:");
    System.out.println("========================");
    StringBuffer sb = new StringBuffer("Hello");
    System.out.println("Original: " + sb);
    System.out.println("Length: " + sb.length());
    System.out.println("Capacity: " + sb.capacity());
    
    sb.insert(5, " World");
    System.out.println("After insert: " + sb);
    
    sb.reverse();
    System.out.println("After reverse: " + sb);
  }
}
