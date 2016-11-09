package chapter01;

class P1_5 {

    public static void main(String[] args) throws Exception {
        assertTrue(isOneEditDistance("pale", "ale"));
        assertTrue(isOneEditDistance("pales", "pale"));
        assertTrue(isOneEditDistance("pale", "bale"));
        assertTrue(!isOneEditDistance("pale", "bake"));
        assertTrue(isOneEditDistance("bale", "bake"));
        assertTrue(isOneEditDistance("a", ""));
        assertTrue(!isOneEditDistance("", ""));
    }

    private static boolean isOneEditDistance(String s1, String s2) {
        if (s1.equals(s2)) return false;

        if (s1.length() == s2.length() + 1) {
            return isInsertion(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return isDeletion(s1, s2);
        } else if (s1.length() == s2.length()) {
            return isReplace(s1, s2);
        }
        return false;
    }

    private static boolean isInsertion(String s1, String s2) {
        return isDeletion(s2, s1);
    }

    private static boolean isDeletion(String s1, String s2) {
        int n = 0;
        int i = 0;
        int k = 0;

        while (true) {
            if (Math.abs(i - k) == 1 && (i >= s1.length() || k >= s2.length())) {
                n++;
                break;
            }

            if (i == k && Math.abs(s1.length() - s2.length()) == 1) {
                n++;
                break;
            }

            if (i >= s1.length()) break;
            if (k >= s2.length()) break;
            if (s1.charAt(i) == s2.charAt(k)) {
                i++;
                k++;
            } else {
                if (i + 1 < s1.length() && s1.charAt(i + 1) == s2.charAt(k)) {
                    n++;
                    i++;
                } else if (k + 1 < s2.length() && s2.charAt(k + 1) == s1.charAt(i)) {
                    n++;
                    k++;
                } else {
                    return false;
                }
            }
        }

        return n == 1;
    }

    private static boolean isReplace(String s1, String s2) {
        int n = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                n++;
                if (n > 1) {
                    return false;
                }
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

