package chapter04;

class P4_5 {

    public static void main(String[] args) {

        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, n1, n2);

        System.out.println(isBST(n3));

        Node n4 = new Node(1, null, null);
        Node n5 = new Node(3, null, null);
        Node n6 = new Node(2, n4, n5);

        System.out.println(isBST(n6));
    }

    private static boolean isBST(Node n) {
        return isBSTAux(n, null, null);
    }

    private static boolean isBSTAux(Node n, Integer min, Integer max) {
        if (n == null) return true;
        if (min != null && n.key < min) return false;
        if (max != null && n.key > max) return false;
        return isBSTAux(n.left, min, n.key) && isBSTAux(n.right, n.key, max);
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
