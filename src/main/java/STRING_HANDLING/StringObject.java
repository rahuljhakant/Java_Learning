package STRING_HANDLING;

public class StringObject {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s.toLowerCase());

        String t = "typo";

        System.out.println(s instanceof String);
        System.out.println(t instanceof String);
        System.out.println(s.startsWith("H"));
        System.out.println(t.startsWith("t"));
        
        // This shows how efficient is java memory management.
        String a = "studytonight";
        String b = "thginotyduts";

        byte[] c = a.getBytes();
        byte[] d = b.getBytes();

        for (byte value : c) {
            System.out.print(value + " , ");
        }
        System.out.println();

        for (byte value : d) {
            System.out.print(value + " , ");
        }
    }
}