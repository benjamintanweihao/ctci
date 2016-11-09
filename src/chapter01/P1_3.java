package chapter01;

class P1_3 {

    public static void main(String[] args) {
        String s = "Mr John Smith     ";
        String u = urlify(s, 13);

        System.out.println(u);
    }

    private static String urlify(String s, int len) {
        int numSpaces = 0 ;
        for (int i = 0; i < len; i++) {
            if (Character.isSpaceChar(s.charAt(i))) {
                numSpaces++;
            }
        }

        int numChars = len + 2 * numSpaces;
        char[] urlCharArr = new char[numChars];

        int k = 0;

        for (int i = 0; i < len; i++) {
            if (Character.isSpaceChar(s.charAt(i))) {
                urlCharArr[k] =  '%';
                urlCharArr[k+1] =  '2';
                urlCharArr[k+2] =  '0';
                k += 3;
            } else {
                urlCharArr[k] =  s.charAt(i);
                k++;
            }
        }

        return String.valueOf(urlCharArr);
    }

}
