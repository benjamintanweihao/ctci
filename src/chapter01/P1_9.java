package chapter01;

class P1_9 {

    public static void main(String[] args) throws Exception {
        // Assumptions: lowercase
        String s1 = "watermelon";
        String s2 = "ermelonwat";

        assertTrue(isRotation(s1, s2));
        assertTrue(isRotation(s2, s1));

        s1 = "xxx";
        s2 = "xxx";

        assertTrue(isRotation(s1, s2));
        assertTrue(isRotation(s2, s1));

        s1 = "";
        s2 = "";

        assertTrue(isRotation(s1, s2));
        assertTrue(isRotation(s2, s1));

        s1 = "samesame";
        s2 = "butdifferent";

        assertTrue(!isRotation(s1, s2));
        assertTrue(!isRotation(s2, s1));
    }

    private static boolean isRotation(String s1, String s2) {
        StringBuilder s2s2 = (new StringBuilder(s2)).append(s2);
        return s2s2.toString().contains(s1);
    }

    private static void assertTrue(boolean result) throws Exception {
        if (!result) {
            throw new Exception("Assertion error");
        }
    }
}
