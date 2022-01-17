package STRING_HANDLING;

public class String_Buffer {
    public static void main(String[] args) {

        // Difference between string and string buffer
        String s = "single".concat(" Plus");
        s.concat("  +  another string");
        System.out.println(s);

        StringBuffer stringBuffer = new StringBuffer("APACHE");
        StringBuffer ss = stringBuffer.append(" + integer");
        System.out.println(stringBuffer);
        System.out.println(ss instanceof StringBuffer);
    }
}
