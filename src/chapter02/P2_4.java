package chapter02;

class P2_4 {

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(5);
        Node n5 = new Node(10);
        Node n6 = new Node(2);
        Node n7 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        printLL(partitionLL(n1, 5));
    }

    private static Node partitionLL(Node n, int partition) {
        Node p1 = null;
        Node p2 = null;
        Node h1 = null;
        Node h2 = null;
        Node curr = n;

        while (curr != null) {
            if (curr.data < partition) {
                if (p1 == null) {
                    p1 = new Node(curr.data);
                    h1 = p1;
                } else {
                    p1.next = new Node(curr.data);
                    p1 = p1.next;
                }
            } else {
                if (p2 == null) {
                    p2 = new Node(curr.data);
                    h2 = p2;
                } else {
                    p2.next = new Node(curr.data);
                    p2 = p2.next;
                }
            }

            curr = curr.next;
        }

        if (p1 != null) {
            p1.next = h2;
        } else {
            return h2;
        }

        return h1;
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
