package chapter01;

class P1_1 {

    public static void main(String[] args) throws Exception {
        String s = "";
        assertTrue(isUniqueSlow(s));

        s = "xxx";
        assertTrue(!isUniqueSlow(s));

        s = "x";
        assertTrue(isUniqueSlow(s));

        s = "abc";
        assertTrue(isUniqueSlow(s));

        s = "abAc";
        assertTrue(!isUniqueSlow(s));

        s = "";
        assertTrue(isUniqueFast(s));

        s = "xxx";
        assertTrue(!isUniqueFast(s));

        s = "x";
        assertTrue(isUniqueFast(s));

        s = "abc";
        assertTrue(isUniqueFast(s));

        s = "abAc";
        assertTrue(!isUniqueFast(s));
    }

    private static boolean isUniqueSlow(String s) {
        if (s.isEmpty()) return true;

        s = s.toLowerCase();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            for (int k = 0; k < charArray.length; k++) {
                if (i != k) {
                    if (charArray[i] == charArray[k]) return false;
                }
            }
        }

        return true;
    }

    private static boolean isUniqueFast(String s) {
        if (s.isEmpty()) return true;

        s = s.toLowerCase();

        char[] charArray = s.toCharArray();
        boolean[] seen = new boolean[128];

        for (int i = 0; i < charArray.length; i++) {
            int index = (int) charArray[i];
            if (seen[index]) {
                return false;
            } else {
                seen[index] = true;
            }
        }

        return true;
    }

    static void assertTrue(boolean result) throws Exception {
        if (!result) {
            throw new Exception("Assertion error");
        }
    }
}
