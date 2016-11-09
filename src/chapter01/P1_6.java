package chapter01;


class P1_6 {

    public static void main(String[] args) throws Exception {
        String s = "aabbcaccbbbbbbba";
        assertTrue(compress(s).equals("a2b2c1a1c2b7a1"));
    }

    private static String compress(String s) {
        if (s.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        char currChar = s.charAt(0);
        int currCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currChar) {
                currCount++;
            } else {
                sb.append(currChar);
                sb.append(currCount);
                currChar = s.charAt(i);
                currCount = 1;
            }
        }

        sb.append(currChar);
        sb.append(currCount);

        return sb.toString();
    }

    static void assertTrue(boolean result) throws Exception {
        if (!result) {
            throw new Exception("Assertion error");
        }
    }
}
