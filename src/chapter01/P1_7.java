package chapter01;

import java.util.Arrays;

class P1_7 {

    public static void main(String[] args) {
        int[][] arr1 = new int[3][3];
        arr1[0][0] = 1;
        arr1[0][1] = 2;
        arr1[0][2] = 3;

        arr1[1][0] = 4;
        arr1[1][1] = 5;
        arr1[1][2] = 6;

        arr1[2][0] = 7;
        arr1[2][1] = 8;
        arr1[2][2] = 9;

        System.out.println(Arrays.deepToString(arr1));
        rotate(arr1);
        System.out.println(Arrays.deepToString(arr1));

        int[][] arr2 = new int[4][4];
        arr2[0][0] = 1;
        arr2[0][1] = 2;
        arr2[0][2] = 3;
        arr2[0][3] = 4;

        arr2[1][0] = 5;
        arr2[1][1] = 6;
        arr2[1][2] = 7;
        arr2[1][3] = 8;

        arr2[2][0] = 9;
        arr2[2][1] = 10;
        arr2[2][2] = 11;
        arr2[2][3] = 12;

        arr2[3][0] = 13;
        arr2[3][1] = 14;
        arr2[3][2] = 15;
        arr2[3][3] = 16;


        System.out.println(Arrays.deepToString(arr2));
        rotate(arr2);
        System.out.println(Arrays.deepToString(arr2));

    }

    private static void rotate(int[][] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int first = i;
            int last = n - 1 - i;
            int top, right, bottom, left;

            for (int j = first; j < last; j++) {
                top = arr[i][j];
                right = arr[j][last];
                bottom = arr[n - 1 - i][n - i - j - 1];
                left = arr[last - j][i];

                int temp = top;

                arr[i][j] = left;
                arr[last - j][i] = bottom;
                arr[n - 1 - i][n - i - j - 1] = right;
                arr[j][last] = temp;
            }
        }
    }
}
