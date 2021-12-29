package OOPS;

public class c_modifiers extends publicClass {
    static int a = publicClass.c;

    public static void main(String[] args) {
        System.out.println(a);
    }
}

class publicClass {
    protected static int c = 10;
    private int p = 20;
}


