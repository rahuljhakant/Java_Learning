package STRING_HANDLING;

/**
 * StringBuilder vs StringBuffer - Performance and Thread Safety Comparison
 * 
 * This class demonstrates the differences between StringBuilder and StringBuffer
 * in terms of performance, thread safety, and usage scenarios.
 */
public class stringBuilder_vs_stringBuffer {
  
  public static void main(String[] args) {
    System.out.println("=== StringBuilder vs StringBuffer Demo ===");
    System.out.println();
    
    // Performance comparison
    demonstratePerformance();
    
    // Thread safety demonstration
    demonstrateThreadSafety();
    
    // Memory usage comparison
    demonstrateMemoryUsage();
  }
  
  /**
   * Demonstrates performance differences between StringBuilder and StringBuffer
   */
  private static void demonstratePerformance() {
    System.out.println("1. Performance Comparison:");
    System.out.println("=========================");
    
    int iterations = 100000;
    String baseString = "Hello";
    
    // StringBuilder performance
    long startTime = System.nanoTime();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < iterations; i++) {
      sb.append(baseString);
    }
    long sbTime = System.nanoTime() - startTime;
    
    // StringBuffer performance
    startTime = System.nanoTime();
    StringBuffer sbf = new StringBuffer();
    for (int i = 0; i < iterations; i++) {
      sbf.append(baseString);
    }
    long sbfTime = System.nanoTime() - startTime;
    
    System.out.println("StringBuilder time: " + sbTime / 1_000_000 + " ms");
    System.out.println("StringBuffer time: " + sbfTime / 1_000_000 + " ms");
    System.out.println("StringBuilder is " + (sbfTime / (double) sbTime) + "x faster");
    System.out.println();
  }
  
  /**
   * Demonstrates thread safety differences
   */
  private static void demonstrateThreadSafety() {
    System.out.println("2. Thread Safety:");
    System.out.println("================");
    System.out.println("StringBuilder: NOT thread-safe (faster, use in single-threaded environments)");
    System.out.println("StringBuffer: Thread-safe (synchronized, use in multi-threaded environments)");
    System.out.println();
  }
  
  /**
   * Demonstrates memory usage patterns
   */
  private static void demonstrateMemoryUsage() {
    System.out.println("3. Memory Usage:");
    System.out.println("===============");
    System.out.println("Both StringBuilder and StringBuffer:");
    System.out.println("- Store data in heap memory (not stack)");
    System.out.println("- Use dynamic resizing");
    System.out.println("- Have similar memory footprint");
    System.out.println("- StringBuffer has slightly more overhead due to synchronization");
    System.out.println();
    
    // Memory usage demonstration
    StringBuilder sb = new StringBuilder();
    StringBuffer sbf = new StringBuffer();
    
    for (int i = 0; i < 1000; i++) {
      sb.append("test");
      sbf.append("test");
    }
    
    System.out.println("After 1000 appends:");
    System.out.println("StringBuilder length: " + sb.length());
    System.out.println("StringBuffer length: " + sbf.length());
    System.out.println("Both have same content length");
  }
}
