package Coding_Questions;
public class String_reverse {
    public static void main(String[] args) {
        String s = ".desrever eb ot sdeen hcihw gnirtS eht si sihT";
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
}
