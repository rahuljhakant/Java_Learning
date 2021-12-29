package OOPS;

public class g_blank_final_variable {
    // blank final variable
    final int a;

    g_blank_final_variable() {
        // initialized blank final
        a = 10;
    }

    public static void main(String[] args) {
        g_blank_final_variable demo = new g_blank_final_variable();
        System.out.println("a = " + demo.a);
    }
}
