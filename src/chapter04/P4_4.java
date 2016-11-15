package chapter04;

class P4_4 {

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, n1, n2);

        System.out.println(isBalanced(n3));

        Node n4 = new Node(1, null, null);
        Node n5 = new Node(2, n4, null);
        Node n6 = new Node(3, n5, null);

        System.out.println(isBalanced(n6));
    }

    private static boolean isBalanced(Node n) {
        if (n == null) return true;
        int diff = Math.abs(height(n.left) - height(n.right));
        if (diff > 1) {
            return false;
        } else {
            return isBalanced(n.left) && isBalanced(n.right);
        }
    }

    private static int height(Node n) {
        if (n == null) return 0;
        else return 1 + Math.max(height(n.left), height(n.right));
    }

    private static class Node {
        Integer key = null;
        Node left = null;
        Node right = null;

        Node(Integer key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
}
