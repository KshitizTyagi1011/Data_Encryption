import java.util.*;
public class S_DES {
    public static int[] EP = new int[] { 4, 1, 2, 3, 2, 3, 4, 1 };
    public static String key = "11101001";
    public static String[][] s0Box = { { "01", "00", "11", "10" }, { "11", "10", "01", "00" },
            { "00", "10", "01", "11" }, { "11", "01", "11", "10" } };
    public static String[][] s1Box = { { "00", "01", "10", "11" }, { "10", "00", "01", "11" },
            { "11", "00", "01", "00" }, { "10", "01", "00", "11" } };

    public static void main(String[] args) {
        String p41 = "";
        String p42 = "";

        // Scanner sc= new Scanner(System.in);
        String plaintText = "00100010";
        System.out.println("8 Bit Plaintext after IP: "+plaintText);

        String left = plaintText.substring(0, 4);
        String right = plaintText.substring(4, 8);
        System.out.println("Left: " + left + " Right: " + right);

        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0) {
                p41 += round(left);
                System.out.println("Left Cipher: " + p41);
            }
            if (i % 2 == 1) {
                p42 += round(right);
                System.out.println("Right Cipher: " + p42);
            }
        }
    }

    private static String round(String left) {
        String output = "";
        String expTable = "";
        for (int i = 0; i < EP.length; i++) {
            expTable += left.charAt(EP[i] - 1);
        }
        System.out.println("After EP: " + expTable);

        String xorEd = xoring(expTable, key);
        System.out.println("Key xor EP: " + xorEd);
        String s0 = xorEd.substring(0, 4);
        String s1 = xorEd.substring(4, 8);
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                output += sBox(s0, i);
            }
            if (i == 1) {
                output += sBox(s1, i);
            }
        }
        System.out.println("Output after SBox: " + output);
        String ans = "";
        int[] p4 = { 2, 4, 3, 1 };
        for (int i = 0; i < p4.length; i++) {
            // System.out.println("p4 i: "+p4[i]);

            ans += output.charAt(p4[i] - 1);
        }
        return ans;
    }

    private static String sBox(String s0, int i) {
        String ans = "";
        String row = s0.charAt(0) + "" + s0.charAt(s0.length() - 1);
        String col = s0.substring(1, (s0.length() - 1));
        if (i == 0) { // s0box
            ans += s0Box[Integer.parseInt(row, 2)][Integer.parseInt(col, 2)];
        } else { // s1box
            ans += s1Box[Integer.parseInt(row, 2)][Integer.parseInt(col, 2)];
        }
        return ans;
    }

    static String xoring(String a, String b) {
        String ans = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    }
}

