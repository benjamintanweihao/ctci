package chapter02;

class P2_2 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        Node result = kthToLast(n1, 4);
        printLL(result);
    }

    // Remove the first (k - 1) nodes
    private static Node kthToLast(Node node, int k) {
        if (k == 1) return node;
        else {
            return kthToLast(node.next, k-1);
        }
    }

    private static void printLL(Node n) {
        Node curr = n;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    static class Node {
        Node next = null;
        int data;

        Node(int d) {
            this.data = d;
        }
    }
}
