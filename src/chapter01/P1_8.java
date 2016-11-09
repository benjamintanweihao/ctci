package chapter01;


import java.util.HashSet;
import java.util.Set;

class P1_8 {

    public static void main(String[] args) {
        int[][] arr = new int[3][2];

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[2][0] = 1;
        arr[2][1] = 1;

        printArr(arr);
        System.out.println();
        zerofy(arr);
        printArr(arr);
    }

    private static void printArr(int[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }

    private static void zerofy(int[][] arr) {
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (arr[x][y] == 0) {
                    xs.add(x);
                    ys.add(y);
                }
            }
        }

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[x].length; y++) {
                if (xs.contains(x) || ys.contains(y)) {
                    arr[x][y] = 0;
                }
            }
        }
    }
}
