package chapter01;

import java.util.Arrays;
import java.util.Collections;

class P1_2 {

    public static void main(String[] args) throws Exception {
        String s1 = "cat";
        String s2 = "cat";

        assertTrue(!checkPermutation(s1, s2));

        s1 = "cat";
        s2 = "tac";

        assertTrue(checkPermutation(s1, s2));

        s1 = "";
        s2 = "tac";

        assertTrue(!checkPermutation(s1, s2));
    }

    static boolean checkPermutation(String s1, String s2) {
        if (s1.equals(s2)) return false;
        if (s1.length() != s2.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    static void assertTrue(boolean result) throws Exception {
        if (!result) {
            throw new Exception("Assertion error");
        }
    }
}

