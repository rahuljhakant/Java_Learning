package Java_Basics;

public class e_conditional_Statements {

  public static void main(String[] args) {
    // switch case using number
    int a = 10;
    String f = "100";
    if (a == 5) {
      System.out.println("a is 5");
    } else if (a == 6) {
      System.out.println("a is 6");
    } else if (a == 7) {
      System.out.println("a is 7");
    } else {
      System.out.println("a is : " + a);
    }

    switch (a) {
      case 1:
        System.out.println("The value for a is 1");
        break;
      case 2:
        System.out.println("The value for a is 2");
        break;
      case 10:
        System.out.println("The value for a is 10");
        break;
      default:
        System.out.println("This is a default block");
    }

    // This is a string case with switch block
    switch (f) {
      case "100":
        System.out.println("This is a string case");
        break;
      default:
        System.out.println("This is a default case");
    }

    // This is an enum case
    enum vowels {
      a,
      e,
      i,
      o,
      u,
    }

    for (vowels v : vowels.values()) {
      switch (v) {
        case a:
          System.out.println("a is a vowel.");
          break;
        case e:
          System.out.println("e is a vowel.");
          break;
        case i:
          System.out.println("i is a vowel.");
          break;
        case o:
          System.out.println("o is a vowel.");
          break;
        case u:
          System.out.println("u is a vowel.");
          break;
      }
    }
  }
}
