package STRING_HANDLING;

public class StringObject {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s.toLowerCase());

        String t = "typo";

        for (boolean b1 : new boolean[]{s instanceof String, t instanceof String, s.startsWith("H"), t.startsWith("t")}) {
            System.out.println(b1);
        }

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