package chapter04;

import java.util.ArrayList;
import java.util.Arrays;

class P4_2 {
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode tree = treeSort(arr);

        System.out.println("In Order");
        inOrder(tree);

        System.out.println("Pre Order");
        preOrder(tree);

        System.out.println("Post Order");
        postOrder(tree);
    }

    private static void inOrder(TreeNode tree) {
        if (tree == null) return;
        inOrder(tree.left);
        System.out.println(tree.key);
        inOrder(tree.right);
    }

    private static void preOrder(TreeNode tree) {
        if (tree == null) return;
        System.out.println(tree.key);
        preOrder(tree.left);
        preOrder(tree.right);
    }

    private static void postOrder(TreeNode tree) {
        if (tree == null) return;
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.key);
    }

    private static TreeNode treeSort(int[] arr) {
        if (arr.length == 0) return null;

        int mid;
        if (arr.length % 2 == 0) {
            mid = arr.length / 2 - 1;
        } else {
            mid = arr.length / 2;
        }

        TreeNode node = new TreeNode(arr[mid]);
        node.left  = treeSort(Arrays.copyOfRange(arr, 0, mid));
        node.right = treeSort(Arrays.copyOfRange(arr, mid + 1, arr.length));
        return node;
    }

    static class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        int key;

        TreeNode(int key) {
            this.key = key;
        }
    }




}
