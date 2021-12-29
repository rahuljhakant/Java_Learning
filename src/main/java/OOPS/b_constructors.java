package OOPS;

final class b_constructors {
    // Constructor Chaining
    private b_constructors() {

    }

    private b_constructors(int a) {
        this();
    }

    private b_constructors(String c) {
        this(10);
    }

    public static void main(String[] args) {
        b_constructors b_constructors = new b_constructors(10);
    }
}
