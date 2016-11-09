package chapter01;

import java.util.HashMap;

class P1_4 {

    public static void main(String[] args) {
        String s = "Tact Coa";
        System.out.println(isPermPalin(s));
    }

    private static boolean isPermPalin(String s) {
        char c;
        int numSpaces = 0;
        HashMap<Character, Integer> h = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            c = Character.toLowerCase(s.charAt(i));

            if (Character.isSpaceChar(c)) {
                if (h.containsKey(c)) {
                    h.put(c, h.get(c) + 1);
                } else {
                    h.put(c, 1);
                }
            } else {
                numSpaces++;
            }
        }

        int numDivByTwo = 0;

        for (Integer count : h.values()) {
            if (count % 2 == 0) {
                numDivByTwo++;
            }
        }

        int len = s.length() - numSpaces;

        if (len % 2 == 0) {
            return numDivByTwo == h.values().size();
        } else {
            return numDivByTwo == h.values().size() - 1;
        }
    }
}
