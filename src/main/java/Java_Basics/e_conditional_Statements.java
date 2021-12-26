package Java_Basics;

public class e_conditional_Statements {
    public static void main(String[] args) {
        int a = 10;
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
    }
}
