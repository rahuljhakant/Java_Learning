package OOPS;

public class f_static_final {

  static final int a;

  static {
    // initialized static blank final
    a = 10;
  }

  public static void main(String[] args) {
    System.out.println("a = " + f_static_final.a);
  }
}
